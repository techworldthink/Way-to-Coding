#include <iostream>
#include <cstdlib>
using namespace std;

struct node {
	int data;
	struct node *next;
};


typedef struct node node;
node *head;

void insert_end() {
	int data;
	node *temp,*pre;

	cout<<"\nEnter value : ";
	cin>>data;

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

void insert_first() {
	int data;
	node *temp;

	cout<<"\nEnter value to insert : ";
	cin>>data;

	temp=(node*)malloc(sizeof(node));
	temp->data=data;

	if(head == NULL) {
		head=temp;
		head->next=NULL;
	} else {
		temp->next=head;
		head=temp;
	}
}

void insert_pos() {
	int data;
	int pos;
	int count=2;
	node *temp,*pre;
	cout<<"\nEnter value to insert : ";
	cin>>data;
	cout<<"\nEnter Position to insert : ";
	cin>>pos;
	temp=head;
	pre=(node*)malloc(sizeof(node));
	pre->data=data;

	if(head == NULL) {
		cout<<"\nList is Empty \n";
	} else if(pos == 1) {
		pre->next=head;
		head=pre;
	} else {
		temp=head;
		while(temp->next != NULL) {
			if(pos==count) {
				pre->next=temp->next;
				temp->next=pre;
				break;
			} else {
				temp=temp->next;
				count++;
			}
		}
	}
}

void display() {
	node *temp;
	int count=1;
	temp=head;
	if(head == NULL) {
		cout<<"\nList is Empty \n";
	} else {
		while(temp->next != NULL) {
			cout<<"List ["<<count<<"] : "<<temp->data<<"\n";
			temp=temp->next;
			count++;
		}
		cout<<"List ["<<count<<"] : "<<temp->data<<"\n";
	}
}

void search() {
	node *temp;
	int flag=0;
	int count=1;
	temp=head;
	int data;
	cout<<"Enter element to search : ";
	cin>>data;

	if(head == NULL) {
		cout<<"\nList is Empty \n";
	} else {
		while(temp->next != NULL) {
			if(data == temp->data) {
				flag=1;
				break;
			}
			temp=temp->next;
			count++;
		}
		if(temp->data == data) {
			flag=1;
		}
		if(flag==1) {
			cout<<"\nFound\n";
		} else {
			cout<<"\nnot found\n";
		}
	}
}

void delete_pos() {
	node *temp;
	temp=head;
	int count=0;
	int pos;
	cout<<"\nEnter position of element for deletion : ";
	cin>>pos;
	int value;
	int flag=0;

	if(head == NULL) {
		cout<<"\nList is Empty \n";
		return;
	}

	if(pos == 0) {
		value = temp->data;
		if(temp->next == NULL) {
			head=NULL;
		} else {
			head=temp->next;
		}
		flag=1;
	}

	while(temp->next != NULL) {
		if(count == pos-1) {
			value = temp->next->data;
			temp->next=temp->next->next;
			flag=1;
			break;
		}
		temp=temp->next;
		count++;
	}

	if(flag==1)
		cout<<"\nDeleted value is "<<value<<"\n";
	else
		cout<<"\nDeletion failed\n";


}

int main() {
	int opt;
	do {
		cout<<"\n1)Insert in FIRST";
		cout<<"\n2)Insert in END";
		cout<<"\n3)Insert @ a Position";
		cout<<"\n4)Display";
		cout<<"\n5)Search";
		cout<<"\n6)Delete";
		cout<<"\n0)Quiet\n";
		cout<<"\nChoose option : ";
		cin>>opt;
		switch(opt) {
			case 1:
				insert_first();
				break;
			case 2:
				insert_end();
				break;
			case 3:
				insert_pos();
				break;
			case 4:
				display();
				break;
			case 5:
				search();
				break;
			case 6:
				delete_pos();
				break;
			deault:
				cout<<"Invalid option ! Try Again..";
		}
	} while(opt!=0);
	return 0;
}
