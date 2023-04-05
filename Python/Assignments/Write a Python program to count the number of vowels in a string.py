#Input data
a= str(input("Enter a word: "))
#Store all vowels in a variable
b= ["a","e","i","o","u"]
#Assign a variable with value 0 to store the count
c=0
#Use for loop to get into the input data and using the if condition check the characters in the input whether they are matching with values stores in variable b and if the condition satisfies add 1 count in the c variable. Atlast print the c variable.
for i in a:
    if i in b:
        c+=1
        
print("Number of vowels in a string : ",c)
