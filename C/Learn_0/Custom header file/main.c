#include <math.h>
#include <stdio.h>
#include "armstrong.h"


int main() {
	int i, sum, num, count = 0,a,b,c,d;
	printf("Armstrong number between 11 and 1000 are:\n");
	for (i = 11; i <= 1000; i++) {
		if(isArmstrong(i)) {
			printf("%d ", i);
		}
	}
}

