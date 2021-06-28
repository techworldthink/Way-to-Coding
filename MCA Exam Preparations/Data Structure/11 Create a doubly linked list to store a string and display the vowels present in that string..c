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

char vowels[11]={'a','e','i','o','u','A','E','I','O','U'};
//char vowels[11][1]={"O","o"};
 
 
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
				//printf("%c",vowels[i]);
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
	
	display();

	return 0;
}
