class Solution {
  public:
    int round(float no){
  		if(ceil(no)-no > .5) return floor(no);
		else  return ceil(no);
	}
	
    int closestNumber(int N , int M) {
   		return M*round(N/float(M));
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N,M;
        
        cin>>N>>M;

        Solution ob;
        cout << ob.closestNumber(N,M) << endl;
    }
    return 0;
}  // } Driver Code Ends
