#funtion definition to find prime or not

def prime(n):
    j=0
    if (n==1):
        j=0					#variable j is not incremented if the input is one
    else:
        for i in range(2,(n//2)):
            if (n%i)==0:			
                j=j+1				#variable j is incremented if there exists other factors for the number
            
    if(j!=0):
        print("Not prime")			#the given number is not prime,if value of j is other than zero
    else:
        print("Given number is prime")		#the given number is prime,if value of j is zero,still after the loop execution
    
n=int(input("Enter the number :"))		#number to be checked is inputted outside the function definition
prime(n)					#function call
