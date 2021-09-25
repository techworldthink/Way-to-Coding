#include<iostream>
using namespace std;

struct node{
	int data;
	struct node *next;
};

int main(){
    int opt=0;

    do{
        cout<<"\n-------------------- MENU -----------------------\n";
        cout<<"1)Add Element\n";
        cout<<"4)Display\n";
        cout<<"0)Exit\n";
        cout<<"opt :: ";
        cin>>opt;

        switch(opt){
            case 1:
                addElement();
                break;
            case 4:
                display();
                break;
            default:
                cout<<"\nInvalid option\n";
        }
        cout<<"\n-------------------------------------------\n";

    }while(opt!='0');
    return 0;
}
