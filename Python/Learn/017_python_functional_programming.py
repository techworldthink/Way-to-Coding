# higher order functions example
def lower_case(text):
    return text.lower()

def print_msge(function_name):
    msge = function_name('ABC abc')
    print(msge)

print_msge(lower_case)


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

# lambda - practical example 1
func = [lambda arg=x: arg * 100 for x in range(1, 5)]
for each in func:
    print(each(),end=" ")    # 100 200 300 400


#------------ Built in Higher order function ---------------

# Map()
# map(fun,iter) - example 1
def multiply(num):
    return num * num
numbers = [1,2,3,4,5]
res = map(multiply,numbers)
print(res)  # <map object at 0x000001E3F6573D90>
for data in res:
    print(data,end=" ") # 1 4 9 16 25

# map - example 2
data = ["ABC","BCD"]
print(list(map(list,data))) # [['A', 'B', 'C'], ['B', 'C', 'D']]


# filter()
def isodd(num):
    return True if num % 2 != 0 else False
nums = [1,2,3,4,5,6]
odd = list(filter(isodd,nums))
print(odd)  # [1, 3, 5]

# filter() + lambda
result = filter(lambda x: x % 2 != 0, nums)
print(list(result)) # [1, 3, 5]


# reduce
from functools import reduce
def multiply(x,y):
    return x*y
print(reduce(multiply,[1,2,3,4]))   # 24