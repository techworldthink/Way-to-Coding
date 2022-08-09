max = 0
i = 0
max_i = 0
a = int(input())
while a != 0:
    if a > max:
        max = a
        max_i = i
    a = int(input())
    i += 1
print(max_i)