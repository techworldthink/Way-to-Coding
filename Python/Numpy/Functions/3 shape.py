import numpy as np

a = np.array([[1,2,3],[4,5,6]])
print(a.shape)

a.shape = (3,2)
print(a)

b = a.reshape(2,3) 
print(b)
