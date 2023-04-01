def fact(num):								#function definition to find factorial of a number
    factorial = 1							
    if num < 0:								#there is no factorial value for negative numbers
        print("Sorry, factorial does not exist for negative numbers")	
    elif num == 0:							#fuctions returns value 1 if entered number is zero
        print("The factorial of 0 is 1")
    else:
        for i in range(1,num+1):					
            factorial = factorial*i					#product from one,upto the entered number is calculated stored in the variable factorial 
        print("The factorial of",num,"is",factorial)
   
n=int(input("Enter the number :"))					#number is inputted outside the function definition
fact(n)									#fuction call to print the factorial
