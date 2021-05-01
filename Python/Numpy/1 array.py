import numpy as np 

#one dimension array
a = np.array([1,2,3]) 
print(a)

#two dimension array
b = np.array([[1, 2], [3, 4]])
print(b)

# ndmin - Specifies minimum dimensions of resultant array
c = np.array([1, 2, 3,4,5], ndmin = 2) 
print(c)

# dtype -Desired data type of array, optional
d = np.array([1, 2, 3], dtype = complex) 
print(d)
