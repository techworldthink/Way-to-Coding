// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int isDigitSumPalindrome(int N) {
        // code here
        int sum=0,reverse=0;
        while(N!=0){
            sum = sum + N%10;
            N=N/10;
        }
        int temp=sum;
        while(temp!=0){
            reverse = reverse*10 + temp%10;
            temp=temp/10;
        }
        return (reverse==sum)?1:0;
        
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.isDigitSumPalindrome(N) << "\n";
    }
}
  // } Driver Code Ends