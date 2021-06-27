string = input("Enter 2 string seperated by comma : ")
string = string.split(' ')
print(string[1][0] + string[0][1:] +" "+ string[0][0] + string[1][1:]  )
