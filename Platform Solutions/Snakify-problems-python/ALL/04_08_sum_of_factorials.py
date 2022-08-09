n = int(input())
f = 1
S = 0
for i in range(1, n +1):
    f *= i
    S += f
print(S)