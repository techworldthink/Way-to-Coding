print("Enter 3 numbers \n")
num1=int(input("first number : "))
num2=int(input("second number : "))
num3=int(input("third number : "))

if num1>num3 and num1>num2:
    print(num1," is large")
elif num2>num3:
    print(num2," is large")
else:
    print(num3," is large")
