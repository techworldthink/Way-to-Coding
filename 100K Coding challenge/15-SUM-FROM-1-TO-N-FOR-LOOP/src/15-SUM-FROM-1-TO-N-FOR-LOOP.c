/*
 ============================================================================
 Name        : 15-SUM-FROM-1-TO-N-FOR-LOOP.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	double i, sum = 0;
	int n;
	setbuf(stdout, NULL);
	printf("Enter the limit to calculate sum : ");
	scanf("%d", &n);
	for (i=1; i<=n; i++) {
		sum = sum+i;
	}
	printf("Sum is : %f", sum);
	return EXIT_SUCCESS;
}
