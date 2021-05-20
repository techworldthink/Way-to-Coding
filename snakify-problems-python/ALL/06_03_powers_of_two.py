N = int(input())
i, p = 0, 1
while p * 2 <= N:
    i, p = i + 1, p * 2
print(i, p)