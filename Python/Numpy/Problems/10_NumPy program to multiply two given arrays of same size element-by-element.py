import numpy as np

nums1 = np.array([[2, 5, 2],[1, 5, 5]])
nums2 = np.array([[5, 3, 4],[3, 2, 5]])

print("Array1:") 
print(nums1)
print("Array2:") 
print(nums2)

print("\nMultiply said arrays of same size element-by-element:")
print(np.multiply(nums1, nums2))
