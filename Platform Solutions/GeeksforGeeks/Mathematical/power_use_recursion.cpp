#include<iostream>
using namespace std;

//mycode
int power(int n,int t){
	return (t!=0)?n*power(n,--t):1;
}

//Test cases
int main(){
	int T,i,no,pow;
	
	cin>>T;
	while(T-- != 0){
		cin>>no>>pow;
		cout<<power(no,pow)<<"\n";
	}
	return 0;
}
