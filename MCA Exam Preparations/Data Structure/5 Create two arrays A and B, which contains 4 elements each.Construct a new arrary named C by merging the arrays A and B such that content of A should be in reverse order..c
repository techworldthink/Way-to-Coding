#include <stdio.h>

int array_A[6]={1,2,3,4,5};
int array_B[6]={6,7,8,9,10};
int array_C[12];
int size=5;



void merge_array(int array_1[],int array_2[]){
	int i,j;
	for(i=size-1;i>=0;i--){
		array_C[i] = array_1[size-1-i];
	}
	for(i=0;i<size;i++){
		array_C[size+i] = array_2[i];
	}

	for(i=0;i<2*size;i++){
		printf("%d",array_C[i]);
	}
	
}


int main() {
	merge_array(array_A,array_B);
	return 0;
}
