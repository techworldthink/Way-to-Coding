/*
 ============================================================================
 Name        : GRADE-FROM-TOTAL-MARK-PERCENTAGE-IF-ELSE-IF.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	float mark;
	setbuf(stdout, NULL);
	printf("Enter the total mark percentage to know your grade : ");
	scanf("%f", &mark);
	if ((mark >= 90) && (mark <=100)) {
		printf("Your grade : A");
	} else if ((mark < 90) && (mark >= 80)) {
		printf("Your grade : B");
	} else if ((mark < 80) && (mark >= 70)) {
		printf("Your grade : C");
	} else if ((mark < 70) && (mark >= 60)) {
		printf("Your grade : D");
	} else if ((mark < 60) && (mark >= 50)) {
		printf("Your grade : E");
	} else if (mark < 50) {
		printf("You failed");
	} else {
		printf("Invalid mark percentage");
	}

	return EXIT_SUCCESS;
}
