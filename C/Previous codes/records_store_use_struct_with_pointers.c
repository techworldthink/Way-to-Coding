#include <stdio.h>
#include <stdlib.h>

struct details{
	char name[25];
	int rollno;
};

typedef struct details records;

int main() {
	int size=10;
	int arr=3;
	int count=0;
	records *p;
	records *tables;
	tables=(records*)calloc(size,sizeof(records));	
	for(p=tables;p<tables+arr;p++){
		printf("\nEnter Name [%d] : ",count);
		scanf("%s",p->name);
		printf("\nEnter ID [%d] : ",count);
		scanf("%d",&p->rollno);
		count++;
	}
	for(p=tables;p<tables+arr;p++){
		printf("\n Name is : %s  ID is : %d ",p->name,p->rollno);
	}
	return 0;
}
