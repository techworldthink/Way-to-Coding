# create
data = [1,2,3,4,5]

# access
print(data[1]) # 2

# change
data[1] = 13
print(data) # [1, 13, 3, 4, 5]

# methods

# add data to the end of that list
data.append("234")
print(data) # [1, 13, 3, 4, 5, '234']

# insert a value to the specified index
data.insert(0,233)
print(data) # [233, 1, 13, 3, 4, 5, '234']

# to extend a list with another list of data
data.extend([3,2,3,3,3,3])
print(data) # [233, 1, 13, 3, 4, 5, '234', 3, 2, 3, 3, 3, 3]

data = [1,2,3]
# to extend a list with tuple data
data.extend((4,5,6))
print(data) # [1, 2, 3, 4, 5, 6]

# remove specified item
data.remove(6)
print(data) # [1, 2, 3, 4, 5]

# remove value from a specified index
# if the index is not found, it will produce an exception
data.pop(0)
print(data) # [2, 3, 4, 5]

# remove value from the last index
data.pop()
print(data) # [2, 3, 4]

# remove value from the specified index
# if an index is not found, do not produce an exception
del data[2]
print(data) # [2, 3]

# delete list
del data

# clear list values
data = [1,2,3]
data.clear()
print(data) # []

# sort
data = [1,2,3,0]
data.sort()
print(data) # [0, 1, 2, 3]

data.sort(reverse = True)
print(data) # [3, 2, 1, 0]

data.reverse()
print(data) # [0, 1, 2, 3]

#case sensitive based sort
data = ["b","a","A"]
data.sort()
print(data) # ['A', 'a', 'b']

data.sort(key = str.upper)
print(data) # ['A', 'a', 'b']

# custom sorting
data = [2,1,3]
def custom_sort(num):
    return abs(100-num)
data.sort(key = custom_sort)
print(data) # [3, 2, 1]

# copy a list
new_data = data.copy()
print(new_data) # [3, 2, 1]
new_data = list(data)
print(new_data) # [3, 2, 1]

# loop
data = [1,2]
for each in data:
    print(each)

# list comprehension
#newlist = [expression for item in iterable if condition == True]

# simple
new_data = [each for each in data]
print(new_data) # [1, 2]

# with conditions
new_data = [each for each in data if each%2==0]
print(new_data) # [2]

# join lists
a = [1,2,3]
b = [4,5,6]
c = a+b
print(c) #[1, 2, 3, 4, 5, 6]