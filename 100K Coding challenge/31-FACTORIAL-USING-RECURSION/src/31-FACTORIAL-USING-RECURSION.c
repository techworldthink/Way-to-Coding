/*
 ============================================================================
 Name        : 31-FACTORIAL-USING-RECURSION.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int fact (int n) ;

int fact (int n) {

	int f = 1;
	/*for(i=1; i<=n; i++) {
	}*/

	if (n!=1) {                 //Why this condition ?? To ensure that when we go on finding factorial of previous numbers
		f = n*fact(n-1);        //there should not be a case when n-1 = 0
		return f;				//To prevent n-1 = 0, we should stop before n = 1
	}
	return f;
}
int main(void) {
	int num, factorial;
	setbuf(stdout, NULL);
	printf("Enter the number whose factorial is to be calculated:");
	scanf("%d", &num);
	factorial = fact(num);
	printf("Factorial of %d is %d", num, factorial);
	return EXIT_SUCCESS;
}
