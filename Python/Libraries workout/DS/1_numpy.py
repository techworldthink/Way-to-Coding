"""
    NumPy is used for working with arrays.
    NumPy is short for "Numerical Python".
    NumPy aims to provide an array object that is up to 50x faster than traditional Python lists.
    The array object in NumPy is called ndarray

    NumPy arrays are stored at one continuous place in memory unlike lists,
    so processes can access and manipulate them very efficiently.

    This behavior is called locality of reference in computer science.

    This is the main reason why NumPy is faster than lists.
    Also it is optimized to work with latest CPU architectures.

    NumPy is a Python library and is written partially in Python,
    but most of the parts that require
    fast computation are written in C or C++
"""

import numpy as np

# (1) To create an array
arr = np.array([1, 2, 3, 4, 5])
print(arr,"  -- ",type(arr))
"""
    [1 2 3 4 5]   --  <class 'numpy.ndarray'>
"""


# (2)  list to array
my_list = [1,2,3]
print(my_list,"  -- ",type(my_list))
arr = np.array([1, 2, 3, 4, 5])
print(arr,"  -- ",type(arr))
"""
    [1, 2, 3]   --  <class 'list'>
    [1 2 3 4 5]   --  <class 'numpy.ndarray'>
"""

# (3) To  check version
print(np.__version__)
"""
    1.22.1
"""

# (4) Tuple to array
arr = np.array((1, 2, 3, 4, 5))
print(arr,"  -- ",type(arr))
"""
    [1 2 3 4 5]   --  <class 'numpy.ndarray'>
"""

# (5) 0-D,1-D,2-D Arrays
# 0-D arrays, or Scalars, are the elements in an array.
# Each value in an array is a 0-D array.
arr = np.array(42)
print(arr)
arr = np.array([1, 2, 3, 4, 5])
print(arr)
arr = np.array([[1, 2, 3], [4, 5, 6]])
print(arr)
arr = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])
print(arr)
"""
     42
     
    [1 2 3 4 5]
    
    [[1 2 3]
     [4 5 6]]

    [[[1 2 3]
      [4 5 6]]
     [[1 2 3]
      [4 5 6]]]
"""

# (6) Check Number of Dimensions
print(arr.ndim)
"""
    3
"""

# (7) Higher Dimensional Arrays
arr = np.array([1, 2, 3, 4], ndmin=5)
print(arr," -- ",arr.ndim)
"""
    [[[[[1 2 3 4]]]]]  --  5
"""

# (8) Access Array Elements
arr = np.array([1, 2, 3, 4])
print(arr[0])
arr = np.array([[1,2,3,4,5], [6,7,8,9,10], [16,17,28,29,410]])
print('2nd element on 1st row: ', arr[0, 1])
print('2nd element on 1st row: ',arr[0][1])
print('1st row: ',arr[0])
print('Exclude 1st row: ',arr[1:])
print('Last element from 2nd dim: ', arr[1, -1])
print('Last element from last dim: ', arr[-1, -1])
"""
    1
    2nd element on 1st row:  2
    2nd element on 1st row:  2
    1st row:  [1 2 3 4 5]
    Exclude 1st row:  [[  6   7   8   9  10]
                       [ 16  17  28  29 410]]
    Last element from 2nd dim:  10
    Last element from last dim:  410
"""

# (9) Slicing arrays
# ([start:end]  OR [start:end:step])
# The result includes the start index, but excludes the end index
arr = np.array([0,1, 2, 3, 4, 5, 6, 7,8,9,10])
print(arr[1:7])
print(arr[1:7:2])
arr = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])
print(arr[1, 1:4])
print(arr[0:2, 2])
print(arr[0:2, 1:4])
"""
    [1 2 3 4 5 6]
    
    [1 3 5]
    
    [7 8 9]
    
    [3 8]
    
    [[2 3 4]
     [7 8 9]]
"""

# (10) Checking the Data Type of an Array
print(arr.dtype)
arr = np.array([1, 2, 3, 4], dtype='S')
print(arr)
print(arr.dtype)
"""
    [b'1' b'2' b'3' b'4']
    |S1
"""


# (11) Converting Data Type on Existing Arrays
arr = np.array([1.1, 2.1, 3.1])
newarr = arr.astype(int)
print(newarr)
print(newarr.dtype)
"""
    [1 2 3]
    int32
"""

# (12) NumPy Array Copy vs View
arr = np.array([1,2,3,4,5])
arr2 = arr.view()
print(arr)
print(arr2)
arr2[1]=22
arr[2]=33
print(arr)
print(arr2)
"""
    [1 2 3 4 5]
    [1 2 3 4 5]
    [ 1 22 33  4  5]
    [ 1 22 33  4  5]
"""
arr = np.array([1,2,3,4,5])
arr2 = arr.copy()
print(arr)
print(arr2)
arr2[1]=22
arr[2]=33
print(arr)
print(arr2)
"""
    [1 2 3 4 5]
    [1 2 3 4 5]
    [ 1  2 33  4  5]
    [ 1 22  3  4  5]
"""


# (13) NumPy Array Shape
arr = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])
print(arr)
print(arr.shape)
newarr = arr.reshape(4, 2)
print(newarr)
print(newarr.shape)
"""
    [[1 2 3 4]
     [5 6 7 8]]
     
    (2, 4)

    [[1 2]
     [3 4]
     [5 6]
     [7 8]]
     
    (4, 2)
"""

# (14) Unknown Dimension
arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])
newarr = arr.reshape(2, 2, -1)
print(newarr)
"""
    [[[1 2]
      [3 4]]
     [[5 6]
      [7 8]]]
"""


# (15) copy,view  (base)
arr = np.array([1,2,3])
a1 = arr.copy()
a2 = arr.view() # return original array
print(a1.base)
print(a2.base)
"""
    None
    [1 2 3]
"""

# (16) Flattening the arrays
arr = np.array([[1, 2, 3], [4, 5, 6]])
newarr = arr.reshape(-1)
print(newarr)
"""
    [1 2 3 4 5 6]
"""


# (17) Join
arr1 = np.array([1, 2, 3])
arr2 = np.array([4,5,6])
newarr = np.concatenate((arr1, arr2))
print(newarr)
arr1 = np.array([[1, 2], [3, 4]])
arr2 = np.array([[5, 6], [7, 8]])
arr = np.concatenate((arr1, arr2), axis=0)
print(arr)
arr = np.concatenate((arr1, arr2), axis=1)
print(arr)
"""
    [1 2 3 4 5 6]

    [[1 2]
     [3 4]
     [5 6]
     [7 8]]
 
    [[1 2 5 6]
     [3 4 7 8]]
"""


# (18) split
arr = np.array([1, 2, 3, 4, 5, 6])
newarr = np.array_split(arr, 4)
print(newarr)
"""
    [array([1, 2]), array([3, 4]), array([5]), array([6])]
"""

# (19) search
arr = np.array([1, 2, 3, 4, 5, 4, 4])
x = np.where(arr == 4)
print(x)
"""
    (array([3, 5, 6], dtype=int64),)
"""


# (20) search
arr = np.array([3, 2, 0, 1])
print(np.sort(arr))
"""
    [0 1 2 3]
"""


# (21) Filtering Arrays
arr = np.array([41, 42, 43, 44])
x = [True, False, True, False]
newarr = arr[x]
print(newarr)
"""
    [41 43]
"""






