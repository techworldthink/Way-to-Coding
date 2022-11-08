#This program print Fibonacci sequence #upto a given number
n=int(input("Enter the number:"))
a, b = 1, 1
while a < n:
    print(a)
    a, b = b, a+b
