data = "string data"
data = """ Multi line string """
data = ''' Multi line String '''

print(data[1])   # first character of string variable
print(len(data)) # length of string

# Looping through a string
for character in data:
  print(character)

# search string
data = "string data"
if "ta" in data:
  print("Searched string present")

# string slicing
data = "abcdefghijk"
print(data[2:])     # cdefghijk
print(data[:3])     # abc
print(data[1:4])    # bcd
print(data[1:-3])   # bcdefgh
print(data[-3:-1])  # ij

data = " abc ABC"
# modify strings
print(data.upper())               # convert to uppercase
print(data.lower())               # convert to lowercase
print(data.strip())               # remove whitespace (left/right)
print(data.replace("abc","EFG"))  # replace string value
print(data.split(" "))            # split the string with whitespaces , return a list

lower = "abc..."
upper = "ABC..."
# concatenate strings
print(lower+upper)  # abc...ABC...
print(lower+"deff") # abc...deff

# concatenate string & number
data = "Roll number is : {}"
print(data.format(30)) # Roll number is : 30

# escape character
data = "here is the way to store \"double quates\" string"
print(data) # here is the way to store "double quotes" string

data = "techworldthink"
# methods
print(data.capitalize())  # Techworldthink
print(data.count('t'))    # 2
print(data.find('w'))     # return first position of searched string, return -1 if not found
print(data.index('w'))    # return first position of searched string, throw a ValueError exception if not found
print(data.isalnum())     # True
print(data.isalpha())     # True
print(data.isdigit())     # False
print(data.islower())     # True
print(data.isupper())     # False
print(data.isnumeric())   # False