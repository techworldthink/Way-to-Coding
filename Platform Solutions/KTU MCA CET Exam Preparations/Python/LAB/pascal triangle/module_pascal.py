from math import factorial
def pascals_triangle(num):
    for i in range(num):
        for j in range(i+1):
            print(factorial(i)//(factorial(j)*factorial(i-j)), end=" ")
        print("")
