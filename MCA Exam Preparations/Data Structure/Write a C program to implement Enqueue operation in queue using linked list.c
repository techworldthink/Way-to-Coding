#include <stdio.h>
#include <stdlib.h>

struct node{
	int data;
	struct node *next;
};

typedef struct node node;
node *head;



void enqueue(int data){
	node *temp=(node *)malloc(sizeof(node));
	node *pre=(node *)malloc(sizeof(node));
	
	temp->data=data;
	temp->next=NULL;
	
	if(head==NULL){
		head = temp;
	}else{
		pre = head;
		while(pre->next != NULL){
			pre=pre->next;
		}
		pre->next=temp;
	}
}

void display(){
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = head;
		while(pre->next != NULL){
			printf("%d -> ",pre->data);
			pre=pre->next;
		}
		printf("%d -> ",pre->data);
	}

}

int main() {
	int data;
	
	while(1){
		printf("\nEnqueue data : ");
		scanf("%d",&data);
		enqueue(data);
		display();
	}
	return 0;
}
