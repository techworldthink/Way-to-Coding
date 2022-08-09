a = input().split()
for i in range(len(a)):
    if a[i] in a[:i]:
        print('YES')
    else:
        print('NO')