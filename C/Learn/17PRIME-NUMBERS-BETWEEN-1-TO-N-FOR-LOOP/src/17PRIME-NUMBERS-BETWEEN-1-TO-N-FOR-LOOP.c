/*
 ============================================================================
 Name        : 17PRIME-NUMBERS-BETWEEN-1-TO-N-FOR-LOOP.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, n, status = 0;
	setbuf(stdout, NULL);
	printf("Enter the number to be checked for prime :");
	scanf("%d", &n);
	for (i=2; i<=n/2; i++) {
		if (n%i==0) {
			status = 1;
			break;
		}
	}
	if (status == 1) {
		printf("%d is not prime", n);
	} else {
		printf("%d is prime", n);
	}
	return EXIT_SUCCESS;
}
