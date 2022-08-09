/*
 ============================================================================
 Name        : 21-SUM-OF-ELEMENTS-IN-AN-ARRAY.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, size;
	setbuf(stdout, NULL);
	printf("Enter the size of the array:");
	scanf("%d", &size);
	int array[size];
	printf("Enter the values to be entered to the array:");
	for (i=0; i<size; i++) {
		scanf("%d", &array[i]);
	}
	int sum = 0;
	for (i=0; i<size; i++) {
		sum = sum+array[i];
	}
	printf("Sum of elements in the array is : %d", sum);
	return EXIT_SUCCESS;
}
