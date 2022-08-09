c = 0
b = int(input())
a = b
while b != 0:
    if b > a:
       c += 1
    a = b
    b = int(input())
print(c)