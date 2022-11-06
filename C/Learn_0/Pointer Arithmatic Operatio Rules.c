#include <stdio.h>
#include <stdlib.h>

/*
Adding two pointers is illegal in c program but pointer and integer addition is legal.
subtraction of two pointers is also legal.
multiplication & division of two pointers are also illegal
*/

int main() {

	int *a;
	int *b;


	a = malloc(sizeof(int)*3);
	b = malloc(sizeof(int)*3);

	*a = 1;
	*b= 2;

	printf("%d\n",*a);
	printf("%d\n",*b);

//	printf("%d",*(a+b));
//	printf("%d",*(a-b));
	printf("%d",*a-*b);

}
