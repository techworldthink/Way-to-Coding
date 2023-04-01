def palin():						#Definition of fuction to find palindrome
    revstr =""						#Declaration of an empty string
 
    for i in string:					#loop for reversing the string
        revstr=i+revstr 
    print("Reversed string :",revstr) 
 
    if(string == revstr): 				#condition to check if inputted and reversed strings are the same
        print("The string is a palindrome.")		
    else: 
        print("The string is not a palindrome.")	

string= input("Enter string : ")			#command to input the string is given outside the function block 
palin()							#function call to find if the string is palindrome or not
