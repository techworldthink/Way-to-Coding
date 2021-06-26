#include <stdio.h>

int array_A[6]={1,2,3,4,5};
int array_B[6]={6,7,8,9,10};
int array_C[12];
int size=5;



void merge_array(int array_1[],int array_2[]){
	int i;

	for(i=0;i<size;i++){
		array_C[i] = array_1[i] * array_2[i];
	}

	for(i=0;i<size;i++){
		printf("%d\t",array_C[i]);
	}
	
}


int main() {
	merge_array(array_A,array_B);
	return 0;
}
