# create tuple
data = (1,"a",True)

# access
print(data[0])  # 1

# slice
print(data[0:3])    #(1, 'a', True)

# doesn't allow item re-assignment
# immutable - Unchangeable
# data[0] = 12 # it's an error

# concatenate
print(data+data) # (1, 'a', True, 1, 'a', True)

# repeate
print(data*2) # (1, 'a', True, 1, 'a', True)

# tuple with one item - not a tuple
data = ("one item")
print(type(data)) # <class 'str'>

# tuple constructor
data = tuple((1,2,3))
print(type(data))    # <class 'tuple'>

#methods
data = (1,2,3)
print(len(data))     # 3
print(max(data))     # 3
print(min(data))     # 1
print(data.count(2)) # 1
print(data.index(1)) # 0

# loop
data = (1,2,3)
for each in data:
    print(each)