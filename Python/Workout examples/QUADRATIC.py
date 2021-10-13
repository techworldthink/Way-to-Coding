#This program find the real solutions #of a quadratic equation
a=int(input("Enter coefficient of x^2:"))
b=int(input("Enter coefficient of x:"))
c=int(input("Enter constant term:"))
d=b**2-4*a*c
if d>0:
    x1=(-b+d**(1/2))/(2*a)
    x2=(-b-d**(1/2))/(2*a)
    print("Solution",x1,x2)
elif d==0:
    x=-b/2*a
    print("Unique solution",x)
else:
    print("No real solutions")
