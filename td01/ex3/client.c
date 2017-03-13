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

int main(int argc, char* argv[])
{
	
	int sd, res;
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

	int demande_donnees = 1;
	send(sd, &demande_donnees, sizeof(demande_donnees), 0);

	int nb_data = -1;
	recv(sd, &nb_data, sizeof(nb_data), 0);
	printf("tcpcli: reading %d datas\n", nb_data);

	int i=0;
	for(i=0; i < nb_data; ++i)
	{
		int size_data = -1;
		recv(sd, &size_data, sizeof(size_data), 0);
		printf("tcpcli:     reading %d characters\n", size_data);
		char* data_received = (char*)malloc(sizeof(size_data));
		int j=0;
		for(j=0; j<size_data-1; ++j){
			data_received[j]='A';
		}
		data_received[j] = '\0';
		recv(sd, data_received, size_data*sizeof(char), 0);
		printf("tcpcli:         data received %s\n", data_received);
		
	}
	demande_donnees = -1;
	send(sd, &demande_donnees, sizeof(demande_donnees), 0);

	return 0;
}
