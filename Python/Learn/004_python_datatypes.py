data = "some data"
print(type(data)) # <class 'str'>

data = 123
print(type(data)) # <class 'int'>

data = 123.2
print(type(data)) # <class 'float'>

data = False
print(type(data)) # <class 'bool'>

data = 1+2j
print(type(data)) # <class 'complex'>

data = [1,2,3]
print(type(data)) # <class 'list'>

data = (1,2,4)
print(type(data)) # <class 'tuple'>

data = {'a' : 1, 'b' :2}
print(type(data)) # <class 'dict'>

data = frozenset({1,2,3})
print(type(data)) # <class 'frozenset'>

data = {1,2,3}
print(type(data)) # <class 'set'>

data = range(10)
print(type(data)) # <class 'range'>

data = b'bytes data'
print(type(data)) # <class 'bytes'>

data = bytearray(34)
print(type(data)) # <class 'bytearray'>

data = memoryview(bytes(32))
print(type(data))  # <class 'memoryview'>

data = None
print(type(data)) # <class 'NoneType'>