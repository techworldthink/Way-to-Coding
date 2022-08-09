max1=0
max2=0
a=int(input())
while a!=0:
    if a>max1 :
        max2=max1
        max1=a
    elif a>max2 :
        max2=a
    a=int(input())
print(max2)