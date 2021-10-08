#prime factorization of a given number
number = int(input("Enter the Number:"))
print()
store_number = number
factor_list = []
while number > 1:
    i=2
    while i <= number :
        if number % i == 0:
            factor_list.append(i)
            number = number / i
        else:
            i = i + 1
factor_list_string = [str(i) for i in factor_list]
print(store_number,"=","x".join(factor_list_string))
print()
