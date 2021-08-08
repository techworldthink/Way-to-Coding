// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
	public:
		int binary_to_decimal(string str){
		    // Code here
		    int i,po,no=0;
	        for(i=str.length()-1,po=0;i>=0;i--,po++){
	            no = no + int(str[i]-48)*pow(2,po);
	        }
	        return no;
		}
};

// { Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
    	string str;
    	cin >> str;
    	Solution ob;
    	int  ans = ob.binary_to_decimal(str);
    	cout << ans <<"\n";
    }
	return 0;
}  // } Driver Code Ends