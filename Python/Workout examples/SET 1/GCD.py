# This program computes the greatest common divisor of two given integers # using the Euclidean Algorithm
a = int(input("Type the first number : "))
b = int(input("Type the second number : "))
while b != 0:
    r = a % b
    a = b
    b = r
print("The GCD of the numbers is", a)
