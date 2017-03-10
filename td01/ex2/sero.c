#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/wait.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <signal.h>
#include <errno.h>

#include "defobj.h"

void process_data(int sockfd, int curr_pid);
void handler (int sig);

int main(int argc, char* argv[])
{

	int sd, newsd, pid, res, curr_pid;
	struct sigaction sa;
	sa.sa_handler = &handler;
	sa.sa_flags = SA_RESTART | SA_NOCLDSTOP;
	sigaction(SIGCHLD, &sa, 0);

	// AF_INET IPv4 protocol
	// socket(int domain, int type, int protocol)
	struct sockaddr_in sin;
	
	/*
	socket - create an endpoint for communication
	int socket(int domain, int type, int protocol);
	*/
	sd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (sd == -1){
		printf("tcpser: err socket");
		exit(-1);
	}

	bzero(&sin, sizeof(sin));
	sin.sin_family = AF_INET; // Represente le type d'adresse

	/*
	htonl, htons, ntohl, ntohs - convert values between host and network byte order
	uint16_t htons(uint16_t hostshort);
	*/
	sin.sin_port = htons(atoi(argv[1]));
	// htons reordonne les octet en fonction de la machine et du reseau utilisé
	// Network byte order vs Host byte order htons or ntohs
	// Little Endian vs Big Endian 

	/*
	bind - bind a name to a socket
	int bind(int sockfd, const struct sockaddr *addr,
			socklen_t addrlen);
	*/
	res = bind(sd, (struct sockaddr *)&sin, sizeof(sin));
	if (res == -1){
		printf("tcpser: err bind");
		exit(-1);
	}

	/*
	listen - listen for connections on a socket
	int listen(int sockfd, int backlog);
	*/
	res = listen(sd, 5);
	if (res == -1){
		printf("tcpser: err listen");
		exit(-1);
	}

	while(1)
	{
		/*
		accept, accept4 - accept a connection on a socket
		int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);
		*/
		printf("tcpser: waiting for client %d\n", getpid());
		newsd = accept(sd, 0, 0);
		if (newsd == -1){
			if (EINTR==errno) {
				continue; /* Restart accept */
			}
			else {
				printf("tcpser: err accept %d\n", getpid());
				exit(-1);
			}
		}	

		pid = fork();
		if (pid == -1) {
			printf("tcpser: err fork");
			exit(-1);
		}
		// else if (pid != 0) {

		// 	// printf("tcpser: waiting for process %d to finish\n", pid);
		// 	// waitpid(pid, 0, WUNTRACED);
		// }
		else if (pid == 0) {
			curr_pid = getpid();
			printf("tcpser: process %d executing...\n", curr_pid);
			process_data(newsd, curr_pid);
			close(newsd);
			printf("tcpser: process %d end\n", curr_pid);
			// exit(0)
			break;
		}
	}
	// printf("FIN %d", curr_pid);
	return 0;
}

void process_data(int sockfd, int curr_pid){
	obj object;
	int res;
	do
	{
		/*
		recv, recvfrom, recvmsg - receive a message from a socket
		ssize_t recv(int sockfd, void *buf, size_t len, int flags);
		*/
		res = recv(sockfd, &object, sizeof(object), 0);
		if (res == -1){
			printf("tcpser: subprocess %d: err recv\n", curr_pid);
			exit(-1);
		}	
		printf("tcpser: subprocess %d: read message : %s %s %d %d %lf\n",
			curr_pid, object.str, object.str2, object.ii, object.jj, object.dd);
		sleep(1);
	} while(object.ii != -1);
}

void handler (int sig)
{
	int status;
	// printf ("Sending PID: %d\n",
	// 		siginfo->si_pid);
	printf("POUIK POUIK\n");
	fflush(0);
	if (waitpid(-1, &status, WNOHANG) == -1){
		printf("error waitpid");
	}
	sleep(3);
}


