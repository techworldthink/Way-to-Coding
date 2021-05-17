/*
 ============================================================================
 Name        : SAMPLE-INPUT-OUTPUT.c
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
	printf("Enter a number:");
	scanf("%d", &num);
	printf("The number you have entered is %d", num);
	return EXIT_SUCCESS;
}
