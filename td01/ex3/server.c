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
#include "defreq.h"

void process_data(int sockfd, int curr_pid);
void handler (int sig);
void send_data(int sockfd, char* type);

int main(int argc, char* argv[])
{
	int sd, newsd, pid, curr_pid;
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
		perror("tcpser: err socket");
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
	if (bind(sd, (struct sockaddr *)&sin, sizeof(sin)) < 0){
		perror("tcpser: err bind");
		exit(-1);
	}

	/*
	listen - listen for connections on a socket
	int listen(int sockfd, int backlog);
	*/
	if (listen(sd, 5) < 0){
		perror("tcpser: err listen");
		exit(-1);
	}

	while(1)
	{
		/*
		accept, accept4 - accept a connection on a socket
		int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);
		*/
		printf("tcpser: waiting for client\n");
		newsd = accept(sd, 0, 0);
		if (newsd == -1){
			if (EINTR==errno) {
				continue; /* Restart accept */
			}
			else {
				perror("tcpser: err accept");
				exit(-1);
			}
		}	

		pid = fork();
		if (pid == -1) {
			perror("tcpser: err fork");
			exit(-1);
		}
		else if (pid == 0) {
			curr_pid = getpid();
			printf("tcpser: subprocess %d: executing...\n", curr_pid);
			process_data(newsd, curr_pid);
			printf("tcpser: subprocess %d: end\n", curr_pid);
			break;
		}
	}
	return 0;
}

void process_data(int sockfd, int curr_pid){
	srand(curr_pid);
	obj object;
	int res, rand_type, i;
	int ask_for_data = -1;
	char* type;
	char* types[3];
	types[0] = "integer";
	types[1] = "string";
	types[2] = "float";
	do
	{
		/*
		recv, recvfrom, recvmsg - receive a message from a socket
		ssize_t recv(int sockfd, void *buf, size_t len, int flags);
		*/
		if (recv(sockfd, &ask_for_data, sizeof(ask_for_data), 0) < 0){
			perror("tcpser: err recv");
			exit(-1);
		}	
		if(ask_for_data == -1)
			break;

		printf("tcpser: subprocess %d: data request %i\n", curr_pid, ask_for_data);

		int nb_data = rand()%8+2;
		
		printf("tcpser: subprocess %d: sending %d datas\n", curr_pid, nb_data);

		if (send(sockfd, &nb_data, sizeof(nb_data), 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}

		for(i=0;i < nb_data; ++i)
		{
			rand_type = rand()%3;
			type = types[rand_type];

			send_data(sockfd, type);
			sleep(1);
		}

		sleep(1);
	} while(ask_for_data != -1);
	close(sockfd);
}

void send_data(int sockfd, char* type){
	int curr_pid = getpid();
    Req req;
	strcpy(req.type, type);
	if (strcmp(type, "integer") == 0){
		int data = rand()%1000;
		req.size = sizeof(int);
		printf("tcpser: subprocess %d: sending data type %s size %d\n",
			curr_pid, req.type, req.size);
		fflush(0);
		if (send(sockfd, &req, sizeof(Req), 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
		if (send(sockfd, &data, req.size, 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
	}
	else if(strcmp(type, "string") == 0){
		int length = rand()%9+1;
		char data[length];
		int j =0;
		for(j=0; j < length-1; ++j)
			data[j] = 'A'+rand()%26;
		data[j] = '\0';
		req.size = sizeof(char)*length;
		printf("tcpser: subprocess %d: sending data type %s size %d\n",
			curr_pid, req.type, req.size);
		fflush(0);
		if  (send(sockfd, &req, sizeof(Req), 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
		if (send(sockfd, &data, req.size, 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
	}
	else if (strcmp(type, "float") == 0){
		float data = (float)rand()/(float)(RAND_MAX/100.0);
		req.size = sizeof(float);
		printf("tcpser: subprocess %d: sending data type %s size %d\n",
			curr_pid, req.type, req.size);
		fflush(0);
		if (send(sockfd, &req, sizeof(Req), 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
		if (send(sockfd, &data, req.size, 0) < 0){
			perror("tcpserv: err send");
			exit(-1);
		}
	} else {
		perror("tcpser: err send_data type unknown");
		exit(-1);
	}
}

void handler (int sig)
{
	int status;
	if (waitpid(-1, &status, WNOHANG) == -1){
		printf("tcpser: error waitpid");
	} else {
		printf("tcpser: handler signal SIGCHLD received\n");
	}
}


