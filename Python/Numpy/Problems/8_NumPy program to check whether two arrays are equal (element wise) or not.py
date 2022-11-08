import numpy as np

nums1 = np.array([2,2,3,2,1])
nums2 = np.array([2,3,4,3,1])


print("Original arrays:")
print(nums1)
print(nums2)

print("\nTest said two arrays are equal (element wise) or not:?")
print(nums1 == nums2)
print(np.equal(nums1, nums2))
