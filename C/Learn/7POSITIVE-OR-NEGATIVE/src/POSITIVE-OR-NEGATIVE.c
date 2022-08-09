/*
 ============================================================================
 Name        : POSITIVE-OR-NEGATIVE.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int num;
	setbuf(stdout, NULL);
	printf("Enter the number to be checked whether positive or negative : ");
	scanf("%d", &num);
	if (num<0) {
		printf("%d is negative", num);

	}
	else if (num>0){
		printf("%d is positive", num);
	}
	else {
		printf("%d is zero", num);
	}
	return EXIT_SUCCESS;
}
