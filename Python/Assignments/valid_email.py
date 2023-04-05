import re
#A regular expression (or RE) specifies a set of strings that matches it; 
#the functions in this module let you check if a particular string matches a given regular expression 
#(or if a given regular expression matches a particular string, which comes down to the same thing).

def is_valid_email(email):
  pattern = r"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
  return re.match(pattern, email) is not None
# Prompt user for input
email = input("Enter an email address: ")

# Check if input is a valid email address
if is_valid_email(email):
    print(f"{email} is a valid email address.")
else:
    print(f"{email} is not a valid email address.")
