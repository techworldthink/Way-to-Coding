import numpy as np

x = np.array([3,5,1,2,3])
y = np.array([2,5,3,2,1])

print("Array A")
print(x)
print("\nArray B")
print(y)

print("\nA>B")
print(np.greater(x, y))

print("\nA>=B")
print(np.greater_equal(x, y))

print("\nA<B")
print(np.less(x, y))

print("\nA<=B")
print(np.less_equal(x, y))
