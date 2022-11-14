#include<iostream>
using namespace std;

class Node {

	public:
		int data;

		Node* next;

		Node() {
			data=0;
			next=NULL;
		}

		Node(int data) {
			this->data = data;
			this->next = NULL;
		}

};

class Linkedlist {

		Node* head;
		int size;

	public:

		Linkedlist() {
			head=NULL;
			this->size=0;
		}

		Linkedlist(int times,int value) {
			head=NULL;
			this->size=0;

			while(times!=0) {
				insertNode(value);
				times--;
				this->size++;
			}
		}

		int getSize() {
			return this->size;
		}

		int getData() {
			return this->head->data;
		}



		Linkedlist operator*(int times) {
			int rounds = times*(this->getSize());
			Linkedlist temp(rounds,head->data);
			return temp;
		}

		Linkedlist operator+(Linkedlist &rhs) {
			Node *head_lhs = this->head;
			Linkedlist head_rhs = rhs;
			Linkedlist temp;

			while(head_lhs != NULL) {
				temp.insertNode(head_lhs->data);
				head_lhs = head_lhs ->next;
			}

			while(head_rhs.head != NULL) {
				temp.insertNode(head_rhs.head->data);
				head_rhs.head = head_rhs.head ->next;
			}

			return temp;
		}

		friend std::ostream& operator << (std::ostream &out,Linkedlist &rhs) {

			Node* temp = rhs.head;

			if (temp == NULL) {
				out<<"List Empty"<<endl;
				return out;

			}
			while(temp!= NULL) {
				out<<temp->data<<" ";
				temp=temp->next;

			}
			return out;
		}

		void insertNode(int);


};



void Linkedlist::insertNode(int data) {
	Node* newNode = new Node(data);
	if(head == NULL) {
		head=newNode;
		return;
	}
	Node* temp = head;
	while(temp->next!=NULL) {
		temp = temp->next;

	}
	temp->next=newNode;

}



Linkedlist operator*(const int &times,Linkedlist &rhs) {
	int rounds = times*(rhs.getSize());
	Linkedlist temp(rounds,rhs.getData());
	return temp;
}

int main() {

	Linkedlist one(3,5);
	cout<<one;
	cout<<"\n";

	Linkedlist two = 3*one;
	cout<<two;
	cout<<"\n";

	Linkedlist three = two + one;
	cout<<three;

}
