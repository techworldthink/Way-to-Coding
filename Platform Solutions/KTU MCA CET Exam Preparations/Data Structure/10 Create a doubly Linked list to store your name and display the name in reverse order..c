#include <stdio.h>
#include <stdlib.h>

struct node{
	char data;
	struct node *next;
	struct node *prev;
};

typedef struct node node;

node *head=NULL;
node *tail=NULL;

 
void insert(char data){
	node *temp=(node *)malloc(sizeof(node));
	node *pre=(node *)malloc(sizeof(node));
	
	temp->data=data;
	temp->next=NULL;
	temp->prev=NULL;
	
	if(head==NULL){
		head = temp;
		tail=temp;
	}else{
		temp->prev = tail;
		tail->next = temp;
		tail=temp;
	}
}




void display(){
	printf("\n");
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = head;
		while(pre->next != NULL){
			printf("%c",pre->data);
			pre=pre->next;
		}
		printf("%c",pre->data);
	}

}

void r_display(){
	printf("\n");
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = tail;
		while(pre->prev != NULL){
			printf("%c",pre->data);
			pre=pre->prev;
		}
		printf("%c",pre->data);
	}

}

int main() {

	insert('J');
	insert('o');
	insert('b');
	insert('i');
	insert('n');
	
	display();
	r_display();

	return 0;
}
