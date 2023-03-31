def radix_sort(arr):
    """
    Implementation of the radix sort algorithm for integers
    """
    # Find the maximum number to know the number of digits
    max_num = max(arr)
    
    # Initialize the digit position to the least significant digit
    digit_position = 1
    
    # Loop through each digit position, from least to most significant
    while max_num // digit_position > 0:
        
        # Create 10 empty buckets, one for each digit (0-9)
        buckets = [[] for _ in range(10)]
        
        # Distribute the numbers into the buckets based on the current digit
        for num in arr:
            digit = (num // digit_position) % 10
            buckets[digit].append(num)
        
        # Reassemble the numbers in order, based on the current digit
        arr = [num for bucket in buckets for num in bucket]
        
        # Move to the next digit position
        digit_position *= 10
        
    return arr

