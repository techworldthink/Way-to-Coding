/*
 ============================================================================
 Name        : 32-POINTERS-IN-C-BASICS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	/*INTEGERS*/
	int i = 5;
	int *p;                     /**p stores the address of a variable, here i*/
	p = &i;
	printf("%d\n", &i);
	printf("%d\n", p);
	printf("%d\n", *p);
	printf("%d\n", &p);

	/*ARRAYS*/
	int arr[] = {5, 3, 5, 6, 4};
	printf("%d\n", arr[0]);
	printf("%d\n", *arr);

	printf("%d\n\n", *(arr+1));

	/*2-D ARRAYS*/
	int array[3][3] = {{1, 2, 3},
				   {4, 5, 6},
				   {7, 8, 9}};
	printf("%d\n", *array[0]); /*Fetch elements row wise*/
	printf("%d\n", *array[0]+2); /*Elements in 1st row can be fetched like this*/
	printf("%d\n", *(*array+2)); /*Fetching elements from 1st row using double pointers*/
	printf("%d\n", *(*(array+2)+2));/*Fetching elements 3rd row, 3rd column */
	/*First * represents the column count and second *represents the row count*/

	return EXIT_SUCCESS;
}
