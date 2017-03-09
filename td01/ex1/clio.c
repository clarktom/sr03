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

	int i;
	for(i=0; i < tablen; ++i)
	{
		send(sd, &(tabobj[i]), sizeof(tabobj[i]), 0);
	}
	exit(0);
	
	return 0;
}
