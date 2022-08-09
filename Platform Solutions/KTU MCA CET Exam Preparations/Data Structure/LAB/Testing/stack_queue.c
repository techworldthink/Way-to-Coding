#include <stdio.h>
#include <string.h>
 
 #define N 10
 int stack_limit = 4;
 int full_limit = 9;
 int stack_front=-1;
 int queue_front=-1;
 int queue_rear=-1;
 
 int array[N];
 
 
 void push(){
 	int value;
 	if(stack_front == 4){
 		printf("Stack is full");
 	}
 	else{
 		printf("\nEnter a value : ");
 		scanf("%d",&value);
 		stack_front +=1;
 		array[stack_front]=value;
 	}
 }
 
 void pop(){
 	if(stack_front == -1){
 		printf("Stack is Empty");
 	}
 	else{
 		stack_front -=1;
 	}
 }
 
 void enqueue(){
 	int value;
 	if(queue_rear == 9){
 		printf("Queue is full");
 	}
 	else{
 		if(queue_rear == -1){
 			queue_front=5;
 			queue_rear =4;
 		}
 		printf("\nEnter a value : ");
 		scanf("%d",&value);
 		queue_rear +=1;
 		array[queue_rear]=value;
 	}
 }
 
 void dequeue(){
 	if(queue_rear == -1){
 	printf("Queue is Empty");
 	}
 	else if(queue_front == 9){
 		printf("Queue is ended");
 	}
 	else{
 		queue_front +=1;
 	}
 }
 void print_stack(){
 	int i=0;
 	int count=1;
 		if(stack_front == -1){
 		printf("\nStack is Empty");
 	}
 	else{
 	for(i=0;i<=stack_front;i++){
 		printf("\nstack[%d] is %d ",count,array[i]);
 		count +=1;
 	}
 }
 }
 
 void print_queue(){
 	int i=0;
 	int count=1;
 	if(queue_rear == -1){
 	printf("\nQueue is Empty");
 	}
 	else if(queue_front == 9){
 		printf("Queue is ended");
 	}
 	else{	
 	for(i=queue_front;i<=queue_rear;i++){
 		printf("\nqueue[%d] is %d ",count,array[i]);
 		count +=1;
 	}
 }
 }
 
int main()
{
	int opt;
	do{
		printf("\n1)PUSH \n2)POP\n3)ENQUEUE\n4)DEQUEUE\n5)PRINT_STACK\n6)PRINT_QUEUE\n0)EXIT");
		printf("\nEnter option : ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				enqueue();
				break;
			case 4:
				dequeue();
				break;
			case 5:
				print_stack();
				break;
			case 6:
				print_queue();
				break;
			defualt:
				printf("\nInvalis option");
					
		}
	}while(opt!=0);

	return 0;
}
