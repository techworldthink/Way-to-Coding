def max_subarray_sum(arr):
    max_sum = float('-inf')
    current_sum = 0
    
    for num in arr:
        current_sum += num
        max_sum = max(max_sum, current_sum)
        current_sum = max(current_sum, 0)
    
    return max_sum

