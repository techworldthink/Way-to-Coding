main_string = input("Type a string : ")
char = main_string[0]
main_string = main_string.replace(char,'$')
print(char+main_string[1:])
