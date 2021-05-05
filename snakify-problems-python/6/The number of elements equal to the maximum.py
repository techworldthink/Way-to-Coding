maxvalue = 0
сount = 1
a = int(input())
while a != 0:
    if a > maxvalue:
        maxvalue = a
        сount = 1
    elif a == maxvalue:
        сount += 1
    a = int(input())
print(сount)