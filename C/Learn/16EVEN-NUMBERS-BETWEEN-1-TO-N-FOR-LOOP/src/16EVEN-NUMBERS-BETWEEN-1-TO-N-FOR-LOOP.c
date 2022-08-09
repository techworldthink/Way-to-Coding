/*
 ============================================================================
 Name        : 16EVEN-NUMBERS-BETWEEN-1-TO-N-FOR-LOOP.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int n, i;
	setbuf(stdout, NULL);
	printf("Enter the limit to print even numbers:");
	scanf("%d", &n);
	for (i=1; i<=n; i++) {
		if (i%2 == 0) {
			printf("%d\n", i);
		}
	}
	return EXIT_SUCCESS;
}
