#include <stdio.h>
#include <stdlib.h>


struct node{
	char data;
	struct node *next;
};

typedef struct node node;

node *head=NULL;

char vowels[11]={'a','e','i','o','u','A','E','I','O','U'};
 
 
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


void display(){
	int i=0;
	printf("\n");
	node *pre=(node *)malloc(sizeof(node));	
	if(head == NULL){
		printf("\nList is Empty \n");
	}else{
		pre = head;
		while(pre->next != NULL){
			for(i=0;i<=9;i++){
				int left = vowels[i] + 1;
				int right = pre->data +1;
				if(left==right){
					printf("%c",pre->data);
					//printf("%c",vowels[i]);
				}
			}
			
			pre=pre->next;
		}
		for(i=0;i<=9;i++){
			int left = vowels[i] + 1;
			int right = pre->data +1;
			if(left==right){
				printf("%c",pre->data);
			}
		}
	}

}



int main() {

	insert('J');
	insert('o');
	insert('b');
	insert('i');
	insert('n');
	insert('j');
	insert('O');
	
	display();

	return 0;
}
