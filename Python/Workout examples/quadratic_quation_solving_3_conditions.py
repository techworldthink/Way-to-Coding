# python program for find solutions of quadratic equations

a=int(input("Enter coefficient of x^2  :  "))
b=int(input("Enter coefficient of x    :  "))
c=int(input("Enter constant term       :  "))

d=b**2 - 4*a*c  # to find discriminant

if d>0:   # condition 1
    x1=(-b + d**(1/2))/(2*a) # solution 1  if d>0
    x2=(-b - d**(1/2))/(2*a) # solution 2  if d>0
    print("Solution  : ",x1,x2)  # to print the solutions
elif d==0: # condition 2
    x=-b/2*a                 #solution is only one because d==0
    print("Unique solution  : ",x)
else:     # condition 3   d<0    ,... d is a negative number
    print("No real solutions")

 
