def find(arr):
    l = len(arr)
    min_sum = float('inf')
    ans = []
    for i in range(l):
        for j in range(i, l):
            tempSum = sum(arr[i:j + 1])
            if tempSum < min_sum:
                min_sum = tempSum
                ans = arr[i:j + 1]

    print("Sub array which will give min sum:", ans)
    print("Min sum:", min_sum)

array = input("Enter array elements separated by a space: ")
array = list(map(int, array.split()))
print("Array:", array)
find(array)
