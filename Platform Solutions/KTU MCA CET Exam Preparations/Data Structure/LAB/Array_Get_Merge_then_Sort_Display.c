#include <stdio.h>
#include <stdlib.h>


int main() {
	int array_1[100],array_2[100];
	int a1_size,a2_size;
	int i,j;
	int temp;
	int total;
	int size=0;
	
	//ARRAY ONE ELEMET GET
	printf("Enter how much elemenet in first array : ");
	scanf("%d",&a1_size);
	printf("\nEnter %d elemenst\n",a1_size);
	for(i=0;i<a1_size;i++){
		printf("\narray_1_[%d] : ",i+1);
		scanf("%d",&array_1[i]);
	}
	
	
	//ARRAY TWO ELEMENT GETTING
	printf("\nEnter how much elemenet in second array : ");
	scanf("%d",&a2_size);
	printf("\nEnter %d elemenst\n",a2_size);
	for(i=0;i<a2_size;i++){
		printf("\narray_1_[%d] : ",i+1);
		scanf("%d",&array_2[i]);
	}
	
	//TOTAL ARRAY ELEMENTS
	total=a1_size+a2_size;
	
	//THIRD AARRAY BY JOINING EXISTING TWO ARRAYS
	for(i=a1_size;i<total;i++){
		array_1[i]=array_2[size];
		size=size+1;
	}
	
	//SORTING THIRD ARRAY
	for(i=total;i>0;i--){
		for(j=0;j<total-1;j++){
			if(array_1[j]>array_1[j+1]){	
			temp=array_1[j];
			array_1[j]=array_1[j+1];
			array_1[j+1]=temp;
			}
		}
	}
	
	printf("\n...............\n");
	
	//PRINTING THIRD ARRAY
	printf("Array elements are : \n");
	for(i=0;i<total;i++){
		printf("Array_[%d] is : %d\n",i,array_1[i]);
	}
	


	
	return 0;
}
