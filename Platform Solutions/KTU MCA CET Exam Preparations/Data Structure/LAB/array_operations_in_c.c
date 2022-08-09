#include <stdio.h>
#include <stdlib.h>


int array[100],i;
int array_count=0;
	
void create(){
	int i;
	printf("\n\n...........................................\n");
	printf("\n Total number of elements in the array : ");
	scanf("%d",&array_count);
	printf("\nEnter %d Elements \n\n",array_count);
	for(i=0;i < array_count; i++){
		printf("Array[%d] : ",i+1);
		scanf("%d",&array[i]);
		printf("\n");
	} 
	printf("\n\n...........................................\n");
}

void insert(){
	int ins_pos,i,new_value;
	
	printf("\n\n...........................................\n");
	
	printf("\nPosition of insertion : ");
	scanf("%d",&ins_pos);
	
	for(i=array_count-1;i>=ins_pos-1;i--){
		array[i+1]=array[i];
	}
	
	printf("Which value you want to add : ");
	scanf("%d",&new_value);
	
	array[ins_pos-1]=new_value;
	
	printf("\n\nNew array is : \n\n ");
	array_count=array_count+1;
	for(i=0;i < array_count; i++){
	printf("%d\n",array[i]);
	} 
	
	printf("\n\n...........................................\n");
	
}

void delete(){
	int del_pos,i;
	printf("\n\n...........................................\n");
	printf("\nEnter the position of array to delete an element : ");
	scanf("%d",&del_pos);
	for(i=del_pos-1;i< array_count-1;i++){
		array[i]=array[i+1];
	}
		
	printf("\n\nNew array is : \n\n ");
	array_count=array_count-1;
	for(i=0;i < array_count; i++){
	printf("%d\n",array[i]);
	} 
	
	printf("\n\n...........................................\n");
}

void view(){
	int i;
	printf("\n\n...........................................\n");
	printf("Elements are : \n");
	for(i=0;i < array_count; i++){
	printf("%d\n",array[i]);
	} 
	printf("\n\n...........................................\n");
}

int main() {
	
	int opt=0;
	while (1){
		printf("\n\n...................\n");
		printf("1) CREATE\n");
		printf("2) INSERT\n");
		printf("3) DELETE\n");
		printf("4) VIEW\n");
		printf("0) QUIET\n\n");
		printf("choose your option : ");
		scanf("%d",&opt);
		printf("\n\n...................\n");
		
		if (opt==0)
			exit(0);
			
		switch(opt){
			case 1:
				create();
				break;
			case 2:
				insert();
				break;
			case 3:
				delete();
				break;
			case 4:
				view();
				break;
			default:
				printf("Invalid option! Try Again.");
		}
	}
	
	printf("ok");
	return 0;
}
