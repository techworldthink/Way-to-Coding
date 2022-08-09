maxcount=1
count=1
n=int(input())
if n==0:
    print(0)
else:
    a=int(input())
    if a==0:
        print(1)
    else:
        while a!=0:
            if n==a:
                count+=1
                if count>maxcount:
                    maxcount=count
                n=a
                a=int(input())
            else:
                count=1
                n=a
                a=int(input())
        print(maxcount)