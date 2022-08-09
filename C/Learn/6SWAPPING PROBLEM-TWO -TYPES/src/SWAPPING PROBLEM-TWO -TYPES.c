/*
 ============================================================================
 Name        : SWAPING.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int num1, num2, temp;
	/*Type one:Using temp variable*/
	num1 = 10;
	num2 = 20;
	/*Swapping begins*/
	temp = num1;
	num1 = num2;
	num2 = temp;
	printf("the numbers after swapping are: %d and %d", num1, num2);
	printf("\n a:%d  b:%d", num1, num2);

	/*Type two without using temp variable*/

	num1 = 10;
	num2 = 20;
	num1 = num1+num2;
	num2 = num1-num2;
	num1 = num1-num2;
	printf("\nnum1 : %d and num2 : %d", num1, num2);
	return EXIT_SUCCESS;
}
