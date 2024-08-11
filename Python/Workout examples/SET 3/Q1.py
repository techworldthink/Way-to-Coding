"""
Given a decimal number, write a Python script to find the length of the longest sequence of consecutive 1s in its binary representation.
"""

# Solution 1
# ======================================================================================

# Define a decimal number
decimal_number = 29  # Binary representation of 29 is 11101

# Convert the decimal number to its binary representation and remove the '0b' prefix
binary_representation = bin(decimal_number)[2:]

# Split the binary representation into sequences of '1's using '0' as the delimiter
ones_sequences = binary_representation.split('0')

# Calculate the length of each sequence of '1's
list_of_lengths = [len(seq) for seq in ones_sequences]

# Find the maximum length among the sequences of '1's
max_length = max(list_of_lengths)

# Print the maximum length
print(max_length)



# Solution 2
# ======================================================================================

def convert_decimal_to_binary(decimal_number):
    """Convert a decimal number to its binary representation as a string."""
    if decimal_number == 0:
        return "0"
    
    binary_representation = ""
    
    # Handle negative numbers (optional)
    is_negative = decimal_number < 0
    if is_negative:
        decimal_number = -decimal_number
    
    while decimal_number > 0:
        remainder = decimal_number % 2
        binary_representation = str(remainder) + binary_representation
        decimal_number = decimal_number // 2
    
    # Add sign for negative numbers (optional)
    if is_negative:
        binary_representation = "-" + binary_representation
    
    return binary_representation

# Convert the decimal number to binary
decimal_number = 29
binary_representation = convert_decimal_to_binary(decimal_number)

# Initialize variables to find the longest sequence of '1's
max_length = 0
current_length = 0

# Iterate over each bit in the binary representation
for bit in binary_representation:
    if bit == '1':
        # Increment the current length of consecutive '1's
        current_length += 1
        if current_length > max_length:
            max_length = current_length
    else:
        # Reset current length if '0' is encountered
        current_length = 0

# Print the length of the longest sequence of '1's
print(max_length)
