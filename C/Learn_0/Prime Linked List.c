#include <stdio.h>

#include <stdlib.h>



struct node {

	int data;

	struct node *next;

};





typedef struct node node;

node *head;



void insert_end(int data) {

	node *temp,*pre;



	temp=(node*)malloc(sizeof(node));

	temp->data=data;



	if(head == NULL) {

		head=temp;

		head->next=NULL;

	} else {

		pre=head;

		while(pre->next != NULL) {

			pre=pre->next;

		}

		pre->next=temp;

		temp->next=NULL;

	}



}



void display() {

	node *temp;

	temp=head;

	while(temp->next != NULL) {

		printf("%d\n",temp->data);

		temp=temp->next;

	}

	printf("%d\n",temp->data);

}





int isPrime(int num) {

	int i;

	for(i=2; i<=num/2; i++) {

		if(num%i == 0) {

			return 0;

		}

	}

	return 1;

}





int *primeNumbers(int count,int num) {

	int *data = malloc(sizeof(int) * count);

	int i = 0;



	while(i!=count) {

		int stat = isPrime(num);


		if(stat ==1 ) {

			data[i]=num;

			i++;

		}

		num++;

	}



	return data;

}



int main() {



	int count;

	int num;

	int i=0;



	printf("Count :: ");

	scanf("%d",&count);

	printf("NUM :: ");

	scanf("%d",&num);



	int *data = primeNumbers(count,num);



	for(i=0; i<count; i++) {

		insert_end(data[i]);

	}



	display();



	return 0;

}
