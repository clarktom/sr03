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
	sin.sin_family = AF_INET;

	/*
	htonl, htons, ntohl, ntohs - convert values between host and network byte order
	uint16_t htons(uint16_t hostshort);
	*/
	sin.sin_port = htons(atoi(argv[1]));

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
		else if (pid == 0) {
			curr_pid = getpid();
			printf("tcpser: process %d executing...\n", curr_pid);
			process_data(newsd, curr_pid);
			printf("tcpser: process %d end\n", curr_pid);
			break;
		}
	}
	return 0;
}

void process_data(int sockfd, int curr_pid){
	srand(curr_pid);
	obj object;
	int res;
	int ask_for_data = -1;
	do
	{
		/*
		recv, recvfrom, recvmsg - receive a message from a socket
		ssize_t recv(int sockfd, void *buf, size_t len, int flags);
		*/
		res = recv(sockfd, &ask_for_data, sizeof(ask_for_data), 0);
		if(ask_for_data == -1)
			break;
		if (res == -1){
			printf("tcpser: subprocess %d: err recv\n", curr_pid);
			exit(-1);
		}	
		printf("tcpser: subprocess %d: data request n%i\n", curr_pid, ask_for_data);

		int nb_data = rand()%10;
		
		printf("tcpser: subprocess %d: sending %d datas\n", curr_pid, nb_data);
		sleep(1);
		send(sockfd,&nb_data,sizeof(nb_data),0);
		
		int i=0; 
		for(i=0;i < nb_data; ++i)
		{
			int size_data = rand()%20;
			printf("tcpser: subprocess %d:     sending %d characters\n", curr_pid, size_data);
			sleep(1);
			send(sockfd, &size_data, sizeof(int), 0);

			char* data = malloc(sizeof(char)*size_data);
			int j =0;
			for(j=0; j < size_data-1; ++j)
				data[j] = 'A'+rand()%26;
			data[j] = '\0';
			printf("tcpser: subprocess %d:         data: %s\n", curr_pid, data);
			sleep(1);
			send(sockfd, data, sizeof(char)*size_data, 0);
		}

		sleep(1);
	} while(ask_for_data != -1);
	close(sockfd);
}

void handler (int sig)
{
	int status;
	if (waitpid(-1, &status, WNOHANG) == -1){
		printf("tcpser: error waitpid");
	}
}


