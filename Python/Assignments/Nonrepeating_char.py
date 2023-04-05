def find_first_non_repeating_character(string):
#This function takes a string as input and returns the first non-repeating 
#character in the string, or None if there are no non-repeating characters.

    # Create a dictionary to store the frequency of each character in the string
    frequency = {}
    for char in string:
        frequency[char] = frequency.get(char, 0) + 1

    # Find the first character in the string with frequency of 1
    for char in string:
        if frequency[char] == 1:
            return char

    # If no non-repeating character is found, return None
    return None

string = input("Enter a string: ")
result = find_first_non_repeating_character(string)
if result:
    print(f"The first non-repeating character in {string} is {result}.")
else:
    print(f"There are no non-repeating characters in {string}.")
