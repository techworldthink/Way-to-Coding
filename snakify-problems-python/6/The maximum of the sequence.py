greatestvalue = 0
a = int(input())
while a != 0:
    if a > greatestvalue:
        greatestvalue = a
    a = int(input())
print(greatestvalue)