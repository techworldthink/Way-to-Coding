# an array of evenly spaced numbers

import numpy as np 
a = np.arange(24) 
print(a)
print(a.ndim)

# now reshape it 
b = a.reshape(2,4,3) 
print(b)

# b is having three dimensions
print(b.ndim)

#This array attribute returns the length of each element of array in bytes.
# dtype of array is int8 (1 byte) 
x = np.array([1,2,3,4,5], dtype = np.int8) 
print(x.itemsize)


# dtype of array is now float32 (4 bytes) 
x = np.array([1,2,3,4,5], dtype = np.float32) 
print(x.itemsize)

x = np.array([1,2,3,4,5]) 
print(x.flags)
