/*
 ============================================================================
 Name        : SUM-OF-TWO-NUMBERS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int num1, num2, result;
	setbuf(stdout, NULL);
	printf("Enter two numbers");
	scanf("%d%d", &num1, &num2);
	result = num1 + num2;
	printf("The sum of two numbers you entered is : %d", result);
	return EXIT_SUCCESS;
}
