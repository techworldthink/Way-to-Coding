# unchangeable
# unordered
# duplicates not allowed

# create
data = set((1,2,3))
data = {1,2,4,5}
print(data) # {1, 2, 4, 5}

# length
print(len(data))    # 4
print(type(data))   # <class 'set'>

# access items
for each in data:
    print(each,end="") # 1245

if 1 in data:
    print("present") # present

# add items
data.add(123)
print(data) # {1, 2, 4, 5, 123}

# add set
data.update({23,233})
print(data) # {1, 2, 4, 5, 233, 23, 123}
data.update([231,2331])

# remove
# if the item doesn't exist, it will raise an error
data.remove(231)
print(data) # {1, 2, 4, 5, 233, 2331, 23, 123}

# if the item doesn't exist, it will not raise an error
data.discard(231)
print(data) # {1, 2, 4, 5, 233, 2331, 23, 123}

# to remove random item
data.pop()
print(data) # {2, 4, 5, 233, 2331, 23, 123}

# to clear a set
data.clear()
print(data) # set()

# to delete a set
del data

# set operations
# return new set
# note: True and 1 are considered the same value in sets
data_1 = {1,2,3}
data_2 = {3,4,5}
print(data_1.union(data_2)) # {1, 2, 3, 4, 5}

# keep only the items that are present in both sets
print(data_1.intersection(data_2)) # {3}

# elements that are NOT present in both
print(data_1.symmetric_difference(data_2)) # {1, 2, 4, 5}

# difference
print(data_1.difference(data_2))  # {1, 2}

# check disjoint set or not
print(data_1.isdisjoint(data_2)) # False

# check subset or not
print(data_1.issubset(data_2)) # False

# keep only the items that are present in both sets
data_1.intersection_update(data_2)
print(data_1) # {3}

# elements that are NOT present in both
data_1.symmetric_difference_update(data_2)
print(data_1) # {4, 5}