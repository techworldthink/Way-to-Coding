/*
 ============================================================================
 Name        : 23-SORTING-AN-ARRAY-USING-SELECTION-SORT.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, j, size, temp;
	setbuf(stdout, NULL);
	printf("Enter the size of the array:");
	scanf("%d", &size);
	int array[size];
	setbuf(stdout, NULL);
	printf("Enter the values to be sorted :");
	for (i=0; i<size; i++) {
		scanf("%d", &array[i]);
	}
	/*Sorting program*/
	for (i=0; i<(size-1); i++) {
		for (j=i+1; j<size; j++) {
			if (array[i]>array[j]) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	/*Displaying array*/
	for (i=0; i<size; i++) {
		printf("%d\t", array[i]);
	}
	return EXIT_SUCCESS;
}
