max = 1
i = 1
max_i = 1
a = int(input())
while a != 0:
    if a > max:
        max = a
        max_i = i
    a = int(input())
    i += 1
print(max_i)