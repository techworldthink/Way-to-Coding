def sum_of_odd_numbers(numbers):
    """
    Find the sum of all odd numbers in a list
    """
    odd_sum = 0
    for num in numbers:
        if num % 2 != 0:
            odd_sum += num
    return odd_sum

# Example usage
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20]
print(sum_of_odd_numbers(numbers))  # Output: (1 + 3 + 5 + 7 + 9 +11+13+15+17+19)

