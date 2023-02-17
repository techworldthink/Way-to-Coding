# lambda
# small anonymous function
# multiple arguments & only one expression
# In situations where an anonymous function is needed for a brief duration, use lambda functions.
converter = lambda currency : currency * 60 
print(converter(100))

sum = lambda value_1,value_2 : value_1 + value_2
print(sum(1,2)) 

# anonymous function inside another function.
def power(num):
    return lambda value : value ** num

get_square = power(2)
print(get_square(10))