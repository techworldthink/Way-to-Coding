/*
 ============================================================================
 Name        : BIGGER-OF-TWO-NUMBERS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int num1, num2;
	setbuf(stdout, NULL);
	printf("Enter the two numbers to be compared : ");
	scanf("%d%d", &num1, &num2);
	if (num1>num2) {
		printf("%d is greater than %d", num1, num2);

	}
	else if (num2>num1) {
		printf("%d is greater than %d", num2, num1);
	}
	else {
		printf("Both are equal");

	}
	return EXIT_SUCCESS;
}
