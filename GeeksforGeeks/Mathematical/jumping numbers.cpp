// { Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution {
  public:
        long long int isjump(long long X){
      int last,seclast;
      if(X/10==0) return 1;
     
      while((X/10)>=1){
          last=X%10;
          seclast =(X/10)%10;
          if(abs(last-seclast)!=1) return -1;
          X /=10;
      }
      return 1;
    }
    long long jumpingNums(long long X) {
        // code here
        long long int no;
        while(X!=0){
            if((no =isjump(X))!=-1){
                return X;
            }
            X--;
        }
    }
};

// { Driver Code Starts.
int main() {
 
        Solution ob;
        cout << ob.jumpingNums(100) << endl;
    
    return 0;
} 
