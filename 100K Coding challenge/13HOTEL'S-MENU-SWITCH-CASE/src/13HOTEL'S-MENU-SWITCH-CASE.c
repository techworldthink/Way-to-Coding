/*
 ============================================================================
 Name        : 13HOTEL'S-MENU-SWITCH-CASE.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int choice;
	setbuf(stdout, NULL);
	printf("You can select dishes from the following menu : \n");
	printf("1. Dosha and chutney\n2. Porotta and beef\n3. Chappati and chicken fry\n4. Kanji and payar\n");
	printf("Enter the option number for ordering the dish : ");
	scanf("%d", &choice);
	switch (choice) {
		case 1:
			printf("You have selected Dosha and chutney");
			break;
		case 2:
			printf("You have selected Porotta and beef");
			break;
		case 3:
			printf("You have selected Chappati and chicken fry");
			break;
		case 4:
			printf("Kanji and payar");
			break;
		default:
			printf("Invalid option number");
			break;
	}
	return EXIT_SUCCESS;
}
