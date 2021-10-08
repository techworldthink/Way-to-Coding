#include <stdio.h>
#include <stdlib.h>

struct node{
	int data;
	struct node *next;
};


typedef struct node node;
node *head;

void insert_end(){
	int data;
	node *temp,*pre;
	
	printf("\nEnter value : ");
	scanf("%d",&data);
	
	temp=(node*)malloc(sizeof(node));
	temp->data=data;
	
	if(head == NULL){
		head=temp;
		head->next=NULL;
	}
	else{
		pre=head;
		while(pre->next != NULL){
			pre=pre->next;
		}
		pre->next=temp;
		temp->next=NULL;
	}
	
}

void display(){
	node *temp;
	temp=head;
	while(temp->next != NULL){
		printf("%d\n",temp->data);
		temp=temp->next;
	}
	printf("%d\n",temp->data);
}


int main() {
	int opt;
	do{
		printf("\n1)Insert in END");
		printf("\n2)Display");
		printf("\nChoose option : ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				insert_end();
				break;
			case 2:
				display();
				break;
			deault:
				printf("Invalid option ! Try Again..");
		}
	}while(opt!=0);
	return 0;
}
