#include <stdio.h>

float sum(int n){
	float sum=0;
	float inc=2;
	
	while(inc <= n){
		sum = sum + 1/inc;
		inc += 2;
		//printf("%f\n",sum);
	}
	
	return sum;
}

int main()
{
	int n;
	float result;
	
	printf("Enter the value of n : ");
	scanf("%d",&n);
	result = sum(n);
	printf("sum is %f",result);
	
	return 0;
}
