/*
 ============================================================================
 Name        : 22-SEARCH-FOR-AN-ELEMENT-IN-AN-ARRAY.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, size, element, status = 0;
	setbuf(stdout, NULL);
	printf("Enter the size of the array:");
	scanf("%d", &size);
	int array[size];
	setbuf(stdout, NULL);
	printf("Enter the values to be inserted :");
	for (i=0; i<size; i++) {
		scanf("%d", &array[i]);
	}
	printf("\nEnter the element to be searched in the array:");
	scanf("%d", &element);
	for (i=0; i<size; i++) {
		if (element == array[i]) {
			printf("Element is found at %d position", i+1);
			status = 1;
			break;
		}
	}
	if (status == 0) {
		printf("Element not found in the array");
	}
	return EXIT_SUCCESS;
}
