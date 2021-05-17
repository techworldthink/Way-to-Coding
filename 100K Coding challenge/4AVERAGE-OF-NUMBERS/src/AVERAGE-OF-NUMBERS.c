/*
 ============================================================================
 Name        : AVERAGE-OF-NUMBERS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	float num1, num2, num3, avg;
	setbuf(stdout, NULL);
	printf("Enter any three numbers to find their average : ");
	scanf("%f%f%f", &num1, &num2, &num3);
	avg = (num1+num2+num3)/3;
	printf("The average of three numbers is : %f", avg);
	return EXIT_SUCCESS;
}
