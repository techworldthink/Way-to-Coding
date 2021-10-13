#include <stdio.h>
#include <stdlib.h>


int main() {
	int *p,*table;
	int size;
	
	printf("Enter array size : ");
	scanf("%d",&size);
	if((table = (int*)malloc(size * sizeof(int))) == NULL){
		printf("NO space available !\n");
		exit(0);
	}
	printf("Enter array values : \n");
	for(p=table;p<table+size;p++){
		scanf("%d",p);
	}
	printf("values are : \n");
	for(p=table;p<table+size;p++){
		printf("%d \n",*p);
	}
}

// malloc calloc free realloc
