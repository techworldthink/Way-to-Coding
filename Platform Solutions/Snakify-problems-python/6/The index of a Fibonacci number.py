a = int(input())
A = 0
B = 1
if a == 1:
    print(1)
else:
    i = 1
    while a > B:
        B,A=A+B,B
        i += 1
    if a == B:
        print(i)
    else:
        print(-1)