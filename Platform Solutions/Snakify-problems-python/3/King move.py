a=int(input())
b=int(input())
c=int(input())
d=int(input())
if ((a==1 or a==8)and(b==1 or b==8)):
    if (c==a or c==a+1) and (d==b or d==b+1):
        print("YES")
    elif (c==a or c==a+1)and(d==b or d==b-1) :
        print("YES")
    elif (c==a or c==a-1)and(d==b or d==b+1) :
        print("YES")
    elif (c==a or c==a-1)and(d==b or d==b-1) :
        print("YES")
    else :
        print("NO")
elif (c==a or c==a+1 or c==a-1)and (d==b or d==b-1 or d==b+1) :
    print("YES")
else :
    print("NO")