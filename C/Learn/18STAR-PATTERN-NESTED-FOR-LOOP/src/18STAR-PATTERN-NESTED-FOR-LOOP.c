/*
 ============================================================================
 Name        : 18STAR-PATTERN-NESTED-FOR-LOOP.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int n, i, j;
	setbuf(stdout, NULL);
	printf("Enter the number of rows required:");
	scanf("%d", &n);
	for (i=1; i<=n; i++) {
		for (j=0; j<i; j++) {
			printf("* ");
		}
		printf("\n");
	}
	printf("\n\n\n");
	for (i=1; i<=n; i++) {
		for (j=n; j>=i; j--) {
			printf("* ");
		}
		printf("\n");
	}
	return EXIT_SUCCESS;
}
