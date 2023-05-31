def find(arr):
    l = len(arr)
    max_sum = float('-inf')
    ans = []
    for i in range(l):
        for j in range(i, l):
            tempSum = sum(arr[i:j + 1])
            if tempSum > max_sum:
                max_sum = tempSum
                ans = arr[i:j + 1]

    print("Sub array which will give maximum sum:", ans)
    print("Maximum sum:", max_sum)

array = input("Enter array elements separated by a space: ")
array = list(map(int, array.split()))
print("Array:", array)
find(array)

