a1 = int(input())
totalnum = 0
while a1 != 0:
    a2 = int(input())
    if a2 != 0 and a1 < a2:
        totalnum += 1
    a1 = a2
print(totalnum)