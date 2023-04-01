def find_longest_sequence(lst):
    # First, create a dictionary to store the length of the longest sequence that ends
    # at each number in the input list
    seq_lengths = {}
    
    longest_seq_len = 0
    
    # For each element in the input list, check if there is a consecutive sequence
    # ending at that element
    for num in lst:
        # If the previous number in the sequence is in the dictionary, then num is
        # part of an existing sequence
        if num-1 in seq_lengths:
            seq_lengths[num] = seq_lengths[num-1] + 1
        else:
            seq_lengths[num] = 1
        
        # Update longest_seq_len if the current sequence is longer
        longest_seq_len = max(longest_seq_len, seq_lengths[num])
    
    return longest_seq_len

input_list = input("Enter a list of elements separated by spaces: ")
lst = list(map(float, input_list.split()))
find_longest_sequence(lst)
