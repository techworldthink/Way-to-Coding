// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
 //67 381 236
 //9075107
class Solution{
	public:
	using ll  = unsigned long long int ;
	ll powm(ll x,ll n,ll M){
		    ll result=1;
		    while(n>0)
		    {
		        if(n % 2 ==1)
		            result=(result * x)%M;
		        x=(x*x)%M;
		        n=n/2;
		    }
		    return result;
	}
   	int Nth_term(int a, int r, int n){
   		ll mod = 1e9 + 7;
   		ll res = powm(r, n-1, mod);
   		res *= a;
   		res %= mod;
   		return int(res);
   	}    
};

// { Driver Code Starts.
int main(){
		Solution ob;
		cout<<ob.Nth_term(67 , 381 ,236);
		//cout<<ob.Nth_term(5 , 4 ,3);
		//cout << ans <<"\n";

	return 0;
}  
