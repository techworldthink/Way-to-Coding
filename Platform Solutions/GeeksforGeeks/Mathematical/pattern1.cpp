#include<iostream>
using namespace std;

void printPat(int n){
    //Your code here
    int i,k,j;
    for(i=n;i>=1;i--){
        for(j=n;j>=1;j--){
            for(k=i;k>=1;k--){
                cout<<j<<" ";
            }
        }
        cout<<"$";
    }
}

int main()
{
	printPat(3);
	
}
