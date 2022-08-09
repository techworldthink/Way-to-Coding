x1=int(input())
y1=int(input())
x2=int(input())
y2=int(input())
a=abs(x1-x2)
b=abs(y1-y2)
if ((a%2==0)and(b%2==0)):
    print("YES")
elif ((a%2!=0)and(b%2!=0)):
    print("YES")
else :
    print("NO")