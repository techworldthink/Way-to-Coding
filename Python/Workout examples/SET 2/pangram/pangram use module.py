import module_pangram as p

value = input("Input a string : ")
if(p.check_pangram(value)):
    print("Pangram")
else:
    print("Not Pangram")
