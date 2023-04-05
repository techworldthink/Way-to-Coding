def minimum_subarray_sum(arr):
   
    n = len(arr)
    min_sum = arr[0]   
    curr_sum = arr[0]  

    for i in range(1, n):
        
        curr_sum = min(arr[i], curr_sum + arr[i])
        
        min_sum = min(min_sum, curr_sum)

    return min_sum

