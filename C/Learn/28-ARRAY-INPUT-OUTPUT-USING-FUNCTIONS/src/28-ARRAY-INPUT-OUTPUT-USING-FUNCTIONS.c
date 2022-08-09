/*
 ============================================================================
 Name        : 28-ARRAY-INPUT-OUTPUT-USING-FUNCTIONS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
int getArray(int arr[], int limit);
void displayArray(int arr[], int limit);


/*Declaring function to get array from the user*/
int getArray(int arr[], int limit) {
	int i;
	printf("Enter the values to be inserted to the array:-");
	for (i=0; i<limit; i++) {
		scanf("%d", &arr[i]);
	}
	return arr[limit];
}

/*Declaring function to print the array*/
void displayArray(int arr[], int limit) {
	int i;
	printf("The array is:-\n");
	for (i=0; i<limit; i++) {
		printf("%d\t", arr[i]);
	}
}
int main(void) {
	int size;
	setbuf(stdout, NULL);
	printf("Enter the size of the array:");
	scanf("%d", &size);
	int array[size];
	array[size] = getArray(array, size);
	displayArray(array, size);

	return EXIT_SUCCESS;
}
