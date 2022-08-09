/*
 ============================================================================
 Name        : 25-CHECK-IF-STRING-IS-PALINDROME.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
	char string[20];
	int i, len, c = 0;
	setbuf(stdout, NULL);
	printf("Enter the string to be checked if palindrome or not :");
	scanf("%s", string);
	len = strlen(string);

	for (i=len-1; i>=0; i--) {
		if (string[len-1-i] == string[i]) {
			c++;
		}
	}
	if (c == len) {
		printf("%s is palindrome", string);
	} else {
		printf("%s is not palindrome", string);
	}
	return EXIT_SUCCESS;
}
