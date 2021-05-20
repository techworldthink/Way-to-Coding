A = int(input())
B = int(input())
for i in range(A + A % 2 - 1, B - 1, -2):
    print(i, end=' ')