# This is a program to check whether a
#given number is a prime.
number = int(input("Type the number to check : "))
conclusion=''
if number == 1 :
    conclusion = 'is not a prime'
    print(number, conclusion)
else :
    for i in range(2, number) :
        if (number % i) == 0 :
            conclusion = 'is not a prime'
            break
        else:
            conclusion = 'is a prime'
    print(number, conclusion)
