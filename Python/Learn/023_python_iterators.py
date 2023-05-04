"""
An object with a countable number of values is an iterator. 
An object that complies with the iterator protocol, which includes the methods __iter__() and __next__(), 
is known as an iterator. 
Iterable objects include sets, dictionaries, lists, and tuples.
"""

# tuple
data = (1,23,434,34)
data_iter = iter(data)
print(next(data_iter))
print(next(data_iter))
print(next(data_iter))
print(next(data_iter))

# string
data =  "text"
data_iter = iter(data)
print(next(data_iter))


# looping through an Iterator
data = [1,2,4,4]
for each in data:
    print(each)


# Create an Iterator
class Data:
    def __iter__(self):
        self.data = 0
        return self
    def __next__(self):
        if self.data <= 20:
            self.data = self.data +  1
            return self.data
        else:
            raise StopIteration
obj = Data()
obj_iterator = iter(obj)
print(next(obj_iterator))
print(next(obj_iterator))