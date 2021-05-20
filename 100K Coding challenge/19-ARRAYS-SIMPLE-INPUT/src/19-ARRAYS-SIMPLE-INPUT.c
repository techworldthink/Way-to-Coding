/*
 ============================================================================
 Name        : 19-ARRAYS-SIMPLE-INPUT.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, a[5];
	setbuf(stdout, NULL);
	printf("Enter 5 values to be stored in the array :");
	for (i=0; i<5; i++) {
		scanf("%d", &a[i]);
	}
	printf("Entered values are:-\n");
	for (i=0; i<5; i++) {
		printf("%d\t", a[i]);
	}
	return EXIT_SUCCESS;
}
