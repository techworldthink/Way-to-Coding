N = int(input())
M = int(input())
x = int(input())
y = int(input())
if M < N:
    if M - x < x:
        x = M - x
    if N - y < y:
        y = N - y
else:
    if N - x < x:
        x = N - x
    if M - y < y:
        y = M - y
if x < y:
    print(x)
else:
    print(y)