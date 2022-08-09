#User function Template for python3

class Solution:
    #Function to return list containing first n fibonacci numbers.
    def printFibb(self,n):
        # your code here
        arr = []
        if n>=1 and n<=84:
            a,b = 1,1
            #print(b)
            arr.append(b)
            for i in range(n-1):
                #print(b)
                arr.append(b)
                a,b=b,b+a
       
        return arr

#{ 
#  Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__ == '__main__': 
    t=int(input())
    for tcs in range(t):
        
        n=int(input())
        res = Solution().printFibb(n)
        for i in range (len (res)):
            print (res[i], end = " ") 
        print()
# } Driver Code Ends