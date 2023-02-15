# Dictionaries

# Ordered
# Changeable
# Duplicates not allowed


# create
data = {
    1:"A",
    2:"B",
    }
print(data)         # {1: 'A', 2: 'B'}
print(data[1])      # A

print(len(data))    # 2
print(type(data))   # <class 'dict'>
print(dict(a='aA',b='bB')) # {'a': 'aA', 'b': 'bB'}

# change value
data[1] = "Aa"
print(data) # {1: 'Aa', 2: 'B'}
# update dictionary
data.update({1:"A"})
print(data) # {1: 'A', 2: 'B'}

# adding new items
data[3] = "C"
print(data) # {1: 'A', 2: 'B', 3: 'C'}
data.update({4:"D"})
print(data) # {1: 'A', 2: 'B', 3: 'C', 4: 'D'}

# remove items
data.pop(2)     # specify key
print(data)     # {1: 'A', 3: 'C', 4: 'D'}
data.popitem()  # removes last inserted item
print(data)     # {1: 'A', 3: 'C'}
del data[1]
print(data)     # {3: 'C'}

data.clear()
print(data)     # {}

# loop
data = {
    1:"A",
    2:"B",
}
for key in data:
    print(key,data[key],end="   ")  # 1 A   2 B
for value in data.values():
    print(value,end="   ")          #  A   B
for key in data.keys():
    print(key,end=" ")              # 1 2
for key,value in data.items():
    print(key,value,end="   ")      # 1 A   2 

# copy a dictionary
data_copy = data.copy()
print(data_copy)    # {1: 'A', 2: 'B'}
data_copy = dict(data)
print(data_copy)    # {1: 'A', 2: 'B'}