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

void insert_first(){
	
	int data;
	node *temp;
	
	printf("\nEnter value to insert : ");
	scanf("%d",&data);
	
	temp=(node*)malloc(sizeof(node));
	temp->data=data;
		
	if(head == NULL){
		head=temp;
		head->next=NULL;
	}
	else{
		temp->next=head;
		head=temp;
	}
}

void display(){
	node *temp;
	int count=1;
	
	temp=head;
	
	while(temp->next != NULL){
		printf("List [%d] : %d\n",count,temp->data);
		temp=temp->next;
		count++;
	}
	printf("List [%d] : %d\n",count,temp->data);
}


int main() {
	int opt;
	do{
		printf("\n1)Insert in FIRST");
		printf("\n2)Insert in END");
		printf("\n3)Display");
		printf("\n0)Quiet\n");
		printf("\nChoose option : ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				insert_first();
				break;
			case 2:
				insert_end();
				break;
			case 3:
				display();
				break;
			deault:
				printf("Invalid option ! Try Again..");
		}
	}while(opt!=0);
	return 0;
}
