def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1  # Target not found in array

# Take user input for the sorted array and target value
arr = [int(x) for x in input("Enter a sorted array of integers (separated by spaces): ").split()]
target = int(input("Enter the target value: "))

# Call binary_search function to find the index of the target value in the array
index = binary_search(arr, target)

# Print the result
if index == -1:
    print("Target value", target, "not found in the array.")
else:
    print("Target value", target, "found at index", index, "in the array.")

