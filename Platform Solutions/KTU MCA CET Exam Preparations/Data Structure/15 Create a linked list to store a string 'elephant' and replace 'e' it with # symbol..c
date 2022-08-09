#include <stdio.h>
#include <stdlib.h>


struct node{
	char data;
	struct node *next;
};

typedef struct node node;

node *head=NULL;

 
 
void insert(char data){
	node *temp=(node *)malloc(sizeof(node));
	node *pre=(node *)malloc(sizeof(node));
	
	temp->data=data;
	temp->next=NULL;
	
	if(head==NULL){
		head = temp;
	}else{
		pre=head;
		while(pre->next != NULL){
			pre=pre->next;
		}
		pre->next = temp;
	}
}


void replace(){
	int right = 'e' + 1;
	int left;
	int i=0;
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = head;
		while(pre->next != NULL){
			left = pre->data + 1;
			if(left==right){
				pre->data = '#';
			}
			pre=pre->next;
		}
		if(left==right){
			pre->data = '#';
		}
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


int main() {

	insert('e');
	insert('l');
	insert('e');
	insert('p');
	insert('h');
	insert('a');
	insert('n');
	insert('t');
	
	replace();
	display();

	return 0;
}
