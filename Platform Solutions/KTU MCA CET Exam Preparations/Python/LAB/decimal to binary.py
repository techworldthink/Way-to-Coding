number  = int(input("Enter a decimal number : "))
binary = []
while number!=0:
    binary.append(number%2)
    number //=2
binary.reverse()
print(binary)
