x1=int(input())
y1=int(input())
x2=int(input())
y2=int(input())
if (abs(x1-x2)==abs(y1-y2)):
    print("YES")
elif (x1-x2==0)or(y1-y2==0):
    print("YES")
else :
    print("NO")