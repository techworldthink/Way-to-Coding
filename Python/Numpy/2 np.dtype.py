import numpy as np

# using array-scalar type
dt = np.dtype(np.int32) 
print(dt)

#int8, int16, int32, int64 can be replaced by equivalent string 'i1', 'i2','i4', etc.
dt = np.dtype('i4')
print(dt)


# using endian notation 
dt = np.dtype('>i4') 
print(dt)

# first create structured data type
dt = np.dtype([('age',np.int8)]) 
print(dt) 

# now apply it to ndarray object
dt = np.dtype([('age',np.int8)]) 
a = np.array([(10,),(20,),(30,)], dtype = dt) 
print(a)
print(a['age'])


student = np.dtype([('name','S20'), ('age', 'i1'), ('marks', 'f4')]) 
print(student)


student = np.dtype([('name','S20'), ('age', 'i1'), ('marks', 'f4')]) 
a = np.array([('abc', 21, 50),('xyz', 18, 75)], dtype = student) 
print(a)













