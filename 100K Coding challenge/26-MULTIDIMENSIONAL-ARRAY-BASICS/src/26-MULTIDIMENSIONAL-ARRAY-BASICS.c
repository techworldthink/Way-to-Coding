/*
 ============================================================================
 Name        : 26-MULTIDIMENSIONAL-ARRAY-BASICS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int rownum, colnum, i, j;
	setbuf(stdout, NULL);
	printf("Enter the number of rows for the 2D array");
	scanf("%d", &rownum);
	printf("Enter the number of columns for the 3D array");
	scanf("%d", &colnum);
	int values[rownum][colnum];
	setbuf(stdout, NULL);
	printf("Enter the values to be inserted");
	for (i=0; i<rownum; i++) {
		for (j=0; j<colnum; j++) {
			scanf("%d", &values[i][j]);
		}
	}
	printf("The values in the array are:-\n");
	for (i=0; i<rownum; i++) {
			for (j=0; j<colnum; j++) {
				printf("%d\t", values[i][j]);
			}
			printf("\n");
		}
	return EXIT_SUCCESS;
}
