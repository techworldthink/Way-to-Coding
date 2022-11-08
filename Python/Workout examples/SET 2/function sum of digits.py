def digit_sum(num):
    digit=1
    while(num//10 != 0):
        digit = digit + num%10
        num = num//10
    return digit

number = int(input("Enter a number : "))
sum = digit_sum(number)
print(sum)
