#include<iostream>
using namespace std;

int search(int arr[],int N,int key){
	int i;
	
	for(i=0;i<N;i++){
		if(arr[i]==key){
			return i;
		}
	}
	return -1;
}

int main()
{
	int T,N,arr[100];
	int i,j;
	int key;
	
	cin>>T;
	
	for(i=0;i<T;i++){
		cin>>N;
		for(j=0;j<N;j++){
			cin>>arr[j];	
		}
		cin>>key;
		cout<<search(arr,N,key);
	}
	
}
