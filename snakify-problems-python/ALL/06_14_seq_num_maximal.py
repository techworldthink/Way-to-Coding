max = 0
с = 1
a = int(input())
while a != 0:
    if a > max:
        max = a
        с = 1
    elif a == max:
        с += 1
    a = int(input())
print(с)