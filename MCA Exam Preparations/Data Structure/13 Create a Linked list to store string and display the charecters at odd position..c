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
		pre->next=temp;
	}
}




void display(){
	printf("\n");
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = head;
		int i= 1;
		while(pre->next != NULL){
			if(i%2==1)
				printf("%c",pre->data);
			pre=pre->next;
			i++;
		}
		if(i%2==1)
			printf("%c",pre->data);
	}

}



int main() {

	insert('e');
	insert('o');
	insert('v');
	insert('d');
	insert('e');
	insert('d');
	insert('n');
	
	display();

	return 0;
}
