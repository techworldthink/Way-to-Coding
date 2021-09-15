#include<iostream>
using namespace std;

#define ARRAY_SIZE 10
int newArray[ARRAY_SIZE];
int elementCount=0;

void addElement(){
    int pos=0;
    int value;

    cout<<"value : ";
    cin>>value;

    if(elementCount+1 <= ARRAY_SIZE ){
        cout<<"\narray["<<elementCount<<"] <- "<<value<<"\n\n";
        newArray[elementCount]=value;
        elementCount++;
    }else{
        cout<<"\nOverflow\n";
    }

}

void deleteElement(){
    u_int8_t pos=0;
    u_int8_t count=0;
    u_int8_t count_=0;
    int value;

    cout<<"value : ";
    cin>>value;
    for(count=0;count<elementCount;count++){
        if(value==newArray[count]){
            for(count_=count;count_<elementCount;count_++){
                newArray[count_] = newArray[count_+1];
            }
            count = elementCount;
            elementCount--;
        }
    }
}

void updateElement(){
    int pos=0;
    int newValue;

    cout<<"pos : ";
    cin>>pos;
    cout<<"Value : ";
    cin>>newValue;
    if(pos > elementCount+1){
        cout<<"\nWriting to this position not allowed\n";
    }else{
        cout<<"\narray["<<pos<<"]"<<newArray[pos]<<"<- "<<newValue<<"\n\n";
        newArray[pos] = newValue;
    }
}

void display(){
    u_int8_t pos=0;
    cout<<"\n............................\n";
    for(pos=0;pos<elementCount;pos++){
        cout<<newArray[pos]<<"\t";
    }
    cout<<"\n............................\n";
}

void swap(int *a,int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(){
    int x,y;
    for(x=0;x<elementCount-1;x++){
        for(y=x;y<elementCount-1;y++){
            if(newArray[y]>newArray[y+1]){
                swap(&newArray[y],&newArray[y+1]);
            }
        }
    }
    display();
}

int main(){
    u_int8_t opt=0;


    do{
        cout<<"\n-------------------------------------------\n";
        cout<<"1)Add Element\n";
        cout<<"2)Delete Element\n";
        cout<<"3)Update Element\n";
        cout<<"4)Display\n";
        cout<<"5)Bubble Sort\n";
        cout<<"0)Exit\n";
        cout<<"opt :: ";
        cin>>opt;

        switch(opt){
            case '1':
                addElement();
                break;
            case '2':
                deleteElement();
                break;
            case '3':
                updateElement();
                break;
            case '4':
                display();
                break;
            case '5':
                bubbleSort();
                break;
            default:
                cout<<"\nInvalid option\n";
        }
        cout<<"\n-------------------------------------------\n";

    }while(opt!='0');
    return 0;
}