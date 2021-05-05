n = int(input())
#sum of first n natural numbers =[n(n+1)]/2
s = (n + 1) * n / 2
for i in range(n-1):
    s -= int(input())
print(int(s))