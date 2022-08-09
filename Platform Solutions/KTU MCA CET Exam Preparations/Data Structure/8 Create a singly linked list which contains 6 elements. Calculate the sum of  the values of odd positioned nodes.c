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

int sum(node *head){
	int sum=0,i=0;
	node *pre=(node *)malloc(sizeof(node));
	if(head==NULL)
		return 0;

	pre = head;
	while(pre->next != NULL){
		++i;
		if(i%2==1){
			sum = sum + pre->data;
		}
		pre=pre->next;
	}
	++i;
	if(i%2==1){
		sum = sum + pre->data;
	}
	
	return sum;
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

	head = insert(head,1);
	head = insert(head,2);
	head = insert(head,3);
	head = insert(head,5);
	head = insert(head,6);
	
	display(head);
	printf("\n sum at odd pos is : %d",sum(head));
	return 0;
}
