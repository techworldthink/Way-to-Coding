#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 100

int stack[MAX];
int top=-1;
int max=100;

bool isEmpty(){
	if(top<=-1){
		return 1;
	}
	else{
		return 0;
	}
}

bool isFull(){
	if(top>=max){
		return 1;
	}
	else{
		return 0;	
	}
}

void push(){
	int value;
	if(isFull()){
		printf("Stack is full\n");
	}
	else{
		printf("Enter push item : ");
		scanf("%d",&value);
		top=top+1;
		stack[top]=value;
		printf("\n%d pushed to stack",value);
	}
}

void pop(){
	if(isEmpty()){
		printf("stack is empty");
	}
	else{
		printf("%d is poped out : ",stack[top]);
		top=top-1;
	}
}

void display(){
	int i;
	if(!isEmpty()){
	for(i=0;i<=top;i++){
		printf("stack[%d] = %d \n",i+1,stack[i]);
	}
	}
	else{
		printf("stack is empty");
	}
}

void peek(){
	if(!isEmpty()){
		printf("top element is : %d",stack[top]);
	}
	else{
		printf("stack is empty");
	}
}

int main() {
	int opt;
	do{
		printf("\n..................\n");
		printf("1)PUSH\n");
		printf("2)POP\n");
		printf("3)PEEK\n");
		printf("4)DISPLAY\n");
		printf("5)QUIET");
		printf("\n..................\n");
		printf("choose your option : ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				peek();
				break;
			case 4:
				display();
				break;
			case 5:
				exit(0);
			default:
			printf("\nInvalid Operation! Try Again... \n");
		}
	}while(1);
	return 0;
}
