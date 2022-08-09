max_2 = -1
a = int(input())
max = 0
while a != 0:
    if a > max:
        max_2 = max
        max = a
    elif a > max_2:
        max_2 = a
    a = int(input())
print(max_2)