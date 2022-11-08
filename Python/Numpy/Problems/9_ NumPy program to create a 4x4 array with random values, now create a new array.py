import numpy as np

nums = np.arange(16, dtype='int').reshape(-1, 4)
print("Original array:")
print(nums)

print("\nNew array after swapping first and last rows of the said array:")
#new_nums = nums[3:3:-1]

nums = nums[[-1,1,2,0]]
print(nums)

"""
num0 = list(nums[0])
num3 = list(nums[3])
nums[0] = num3
nums[3] = num0
print(nums)
"""

#####################################################################

# start through not past stop, by step
# a[start:stop:step]
# a[::-1]    # all items in the array, reversed
# a[1::-1]   # the first two items, reversed
# a[:-3:-1]  # the last two items, reversed
# a[-3::-1]  # everything except the last two items, reversed

# reference
# https://stackoverflow.com/questions/509211/understanding-slice-notation
