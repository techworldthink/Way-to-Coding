def is_prime(num):
    """
    Check if a number is prime or not
    """
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

def sum_of_primes(numbers):
    """
    Find the sum of all prime numbers in a list
    """
    primes_sum = 0
    for num in numbers:
        if is_prime(num):
            primes_sum += num
    return primes_sum

# Example usage
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19]
print(sum_of_primes(numbers))  # Output: 77 (2 + 3 + 5 + 7 +11 +13 +17+19 = 77)

