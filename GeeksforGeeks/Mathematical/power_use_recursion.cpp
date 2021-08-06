#include<iostream>
using namespace std;

int power(int n,int t){
	if(t!=0){
		--t;
		return n*power(n,t);
	}
	else{
		return 1;
	}
}

int main(){
	int T,i,no,pow;
	
	cin>>T;
	
	while(T-- != 0){
		cin>>no>>pow;
		cout<<power(no,pow)<<"\n";
	}
	return 0;
}
