/*
 ============================================================================
 Name        : ARITHMETIC.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	float num1, num2, result;
	int choice;
	int is_valid = 1;
	setbuf(stdout, NULL);
	printf("Enter the two numbers : ");
	scanf("%f%f", &num1, &num2);
	printf("Available arithmetic operations are:-\n");
	printf("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n");
	printf("Enter the option number to perform the function : ");
	scanf("%d", &choice);
	if (choice == 1) {
		result = num1 + num2;
	} else if (choice == 2) {
		result = num1 - num2;
	} else if (choice == 3) {
		result = num1 * num2;
	} else if (choice == 4) {
		result = num1/num2;
	} else {
		printf("Invalid option number");
		is_valid = 0;
	}
	if (is_valid == 1) {
		printf("Result is %f", result);
	}
	return EXIT_SUCCESS;
}
