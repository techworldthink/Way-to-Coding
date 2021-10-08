#include<iostream>
using namespace std;

class palindrom{
	public:
	int start;
	int stop;
	
	int palindrom_check(int num){
		int value;
		int digit, rev = 0;
		value =num;
		do{
         digit = num % 10;
         rev = (rev * 10) + digit;
         num = num / 10;
     	} while (num != 0);

     //cout << " The reverse of the number is: " << rev << endl;

     if (value == rev)
         return value;
     else
         return 0;

    return 0;
		
	}
	
	void set(){
		cout<<"start no : ";
		cin>>start;
		cout<<"stop no : ";
		cin>>stop;
	}
	
	void sum(){
		int i;
		int sum=0;
		
		for(i=start;i<stop;i++){
			sum = sum + palindrom_check(i);
		}
		
		cout<<"sum is "<<sum;
	}
};



int main()
{
	palindrom obj;
	obj.set();
	obj.sum();
	return 0;
}
