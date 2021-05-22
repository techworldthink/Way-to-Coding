/*
 ============================================================================
 Name        : 27-ADDITION-OF-TWO-2D-ARRAYS.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i, j, rownum, colnum;
	setbuf(stdout, NULL);
	printf("Enter the number of rows in the array:");
	scanf("%d", &rownum);
	printf("Enter the number of columns in the array:");
	scanf("%d", &colnum);
	int array1[rownum][colnum], array2[rownum][colnum], arraysum[rownum][colnum];
	setbuf(stdout, NULL);
	/*First array*/
	printf("Enter the values for the first array:-\n");
	for (i=0; i<rownum; i++) {
		for (j=0; j<colnum; j++) {
			scanf("%d", &array1[i][j]);
		}
	}
	/*second array*/
	printf("Enter the values for the second array:-\n");
	for (i=0; i<rownum; i++) {
		for (j=0; j<colnum; j++) {
			scanf("%d", &array2[i][j]);
		}
	}
	/*Adding arrays*/
	for (i=0; i<rownum; i++) {
		for (j=0; j<colnum; j++) {
			arraysum[i][j] = array1[i][j] + array2[i][j];
		}
	}
	/*Printing the resultant array*/
	for (i=0; i<rownum; i++) {
		for (j=0; j<colnum; j++) {
			printf("%d\t", arraysum[i][j]);
		}
		printf("\n");
	}
	return EXIT_SUCCESS;
}
