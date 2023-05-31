def bubble_sort(arr):
    n = len(arr)

    # Traverse through all array elements
    for i in range(n):
        # Last i elements are already sorted
        for j in range(0, n - i - 1):
            # Swap if the element found is greater than the next element
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr
array= input("enter array element:")
array = list(map(int, array.split()))
print("input array: " ,array)
bubble_sort(array)
print("sorted array: " ,array)
