/*
 ============================================================================
 Name        : DAY-OF-WEEK-SWITCH-CASE-PRG.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int day_num;
	setbuf(stdout, NULL);
	printf("Enter the number of day you want to know : ");
	scanf("%d", &day_num);
	switch (day_num) {
	case 1:
		printf("Monday");
		break;
	case 2:
		printf("Tuesday");
		break;
	case 3:
		printf("Wednesday");
		break;
	case 4:
		printf("Thursday");
		break;
	case 5:
		printf("Friday");
		break;
	case 6:
		printf("Saturday");
		break;
	case 7:
		printf("Sunday");
		break;
	default:
		printf("Invalid entry");
		break;
	}
	return EXIT_SUCCESS;
}
