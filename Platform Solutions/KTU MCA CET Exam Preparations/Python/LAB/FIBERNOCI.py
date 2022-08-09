#This program print Fibonacci sequence #upto a given number

def fibernoci(n):
    a, b = 1, 1
    while a < n:
        print(a)
        a, b = b, a+b
    
n=int(input("Enter the number:"))
fibernoci(n)
