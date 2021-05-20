/*
 ============================================================================
 Name        : 20-ARRAYS-OF-VARYING-SIZE-INPUT.c
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
	printf("Enter the array size:");
	scanf("%d", &size);
	char a[size];
	setbuf(stdout, NULL);
	printf("Enter the names to be inserted to the array");
	for (i=0; i<size; i++) {
		scanf("%d", &a[i]);
	}
	printf("The values in the array are:\n");
	for (i=0; i<size; i++) {
		printf("%d\t", a[i]);
	}
	return EXIT_SUCCESS;
}
