#include <stdio.h>

int array_A[6]={1,2,3,4,5};
int array_B[6]={6,7,8,9,10};
int array_C[12];
int size=5;



void merge_array(int array_1[],int array_2[]){
	int i,j,count=1;
	for(i=0,j=0;i<size;i++,j=j+2){
		array_C[j] = array_1[i];
		array_C[j+1] = array_2[i];
	}

	for(i=0;i<2*size;i++){
		printf("%d",array_C[i]);
	}
	
}


int main() {
	merge_array(array_A,array_B);
	return 0;
}
