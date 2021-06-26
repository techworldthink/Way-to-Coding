#include <stdio.h>
#include <stdlib.h>

struct node{
	int data;
	struct node *next;
};

typedef struct node node;


 node *insert(node *head,int data){
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
	return head;
}

node *merge(node *head,node *tail){
	node *pre=(node *)malloc(sizeof(node));
	if(head==NULL)
		return tail;

	pre = head;
	while(pre->next != NULL){
		pre=pre->next;
	}
	pre->next=tail;
	
	return head;
}


void display(node *head){
	printf("\n");
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
	node *head=NULL;
	node *tail=NULL;
	node *full;
	
	head = insert(head,1);
	head = insert(head,2);
	head = insert(head,3);
	
	tail = insert(tail,5);
	tail = insert(tail,6);
	tail = insert(tail,7);
	
	display(head);
	display(tail);
	
	full = merge(head,tail);
	display(full);
	
	return 0;
}
