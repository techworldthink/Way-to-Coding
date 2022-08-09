A=int(input())
B=int(input())
if A<B:
    for i in range(A-1,B,1):
        print(i+1)
elif A>B:
    for k in range(A,B-1,-1):
        print(k)
else:
    print(A)