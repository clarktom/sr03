#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/wait.h>
#include <arpa/inet.h>
#include <netdb.h>

#include "iniobj.h"
#include "defreq.h"

int main(int argc, char* argv[])
{
	
	int sd, res, i, ask_for_data, nb_data;
	struct sockaddr_in sin;
	struct hostent* hp;
	
	sd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (sd == -1){
		printf("tcpcli: err socket");
		exit(-1);
	}

	/*
	bzero - write zero-valued bytes
	void bzero(void *s, size_t n);
	*/
	bzero(&sin, sizeof(sin)); // Init sin to bzero
	sin.sin_family = AF_INET; // Represente le type d'adresse

	hp = gethostbyname(argv[1]);
	bcopy(hp->h_addr, &sin.sin_addr, hp->h_length);
	sin.sin_family = hp->h_addrtype;
	sin.sin_port = htons(atoi(argv[2]));

	res = connect(sd, (struct sockaddr*)&sin, sizeof(sin));
	if (res == -1){
		printf("tcpcli: err connect");
		exit(-1);
	}

	ask_for_data = 1;
	send(sd, &ask_for_data, sizeof(ask_for_data), 0);

	nb_data = -1;
	recv(sd, &nb_data, sizeof(nb_data), 0);
	printf("tcpcli: reading %d datas\n", nb_data);

	for(i=0; i < nb_data; ++i)
	{
		receive_data(sd);
	}

	ask_for_data = -1;
	send(sd, &ask_for_data, sizeof(ask_for_data), 0);

	return 0;
}

void receive_data(int sd){
	Req req;
	if (recv(sd, &req, sizeof(Req), 0) < 0){
		printf("tcpcli: err recv");
		exit(-1);
	}
	printf("tcpcli: type received %s\n", req.type);
	if (strcmp(req.type, "integer") == 0) {
		int data;
		recv(sd, &data, req.size, 0);
		printf("tcpcli: type %s\n", req.type);
		printf("tcpcli: data %d\n", data);
	} else if (strcmp(req.type, "string") == 0) {
		char data[req.size/sizeof(char)];
		recv(sd, &data, req.size, 0);
		printf("tcpcli: type %s\n", req.type);
		printf("tcpcli: data %s\n", data);
	} else if (strcmp(req.type, "float") == 0) {
		float data;
		recv(sd, &data, req.size, 0);
		printf("tcpcli: type %s\n", req.type);
		printf("tcpcli: data %f\n", data);
	} else {
		printf("tcpcli: err send_data type unknown %s\n", req.type);
		exit(-1);
	}
}
