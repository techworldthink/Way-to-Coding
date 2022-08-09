/*
 ============================================================================
 Name        : 30-PRINT-ALL-ASCII-VALUES.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int i;
	for(i=0; i<=127; i++) {
		printf("%d : %c\n", i, i);
	}
	return EXIT_SUCCESS;
}
