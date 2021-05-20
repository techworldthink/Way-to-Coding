a = [int(s) for s in input().split()]
с = 0
for i in range(1, len(a)-1):
    if a[i - 1] < a[i] > a[i + 1]:
        с += 1
print(с)