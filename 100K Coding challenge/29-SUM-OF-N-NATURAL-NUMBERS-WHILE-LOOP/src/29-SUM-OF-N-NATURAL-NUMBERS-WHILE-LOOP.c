/*
 ============================================================================
 Name        : 29-SUM-OF-N-NATURAL-NUMBERS-WHILE-LOOP.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i = 1, n, sum = 0;  /*Initialization of i*/
	setbuf(stdout, NULL);
	printf("Enter the limit to which you have to find the sum:");
	scanf("%d", &n);
	while (i<=n) {
		sum += i;
		i++;
	}
	printf("Sum is %d", sum);
	return EXIT_SUCCESS;
}
