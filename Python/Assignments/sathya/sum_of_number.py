num = int(input("Enter a number: "))   # Taking input from user

# Initializing sum variable
sum = 0

# Loop to extract and add each digit of number to sum
while num > 0:
    digit = num % 10   # Extracting the rightmost digit
    sum += digit       # Adding digit to sum
    num //= 10         # Removing the rightmost digit from number

print("The sum of digits is:", sum)
