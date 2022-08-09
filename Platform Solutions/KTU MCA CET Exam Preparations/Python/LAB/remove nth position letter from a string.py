string = input("Enter a string")
pos =int(input("Position of letter to be remove :"))
if(pos<=0 or pos>len(string)):
    print("Invalid position")
else:
    replaced = string[:pos-1] + string[pos:]
    print(replaced)
