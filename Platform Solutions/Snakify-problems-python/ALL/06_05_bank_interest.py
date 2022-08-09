x = int(input())
p = int(input())
y = int(input())
i = 0
while x < y:
    x += x * p / 100 # alternative variant: x *= 1 + p / 100
    x = int(x * 100) / 100
    i += 1
print(i)