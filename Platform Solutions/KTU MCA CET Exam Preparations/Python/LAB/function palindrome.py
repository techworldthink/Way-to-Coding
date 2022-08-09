def palindrome(n):
    index=0
    check=True
    while index < len(n):
        if n[index]==n[-1-index]:
            index+=1
            check =  True
        else:
            check =  False
            break
    return check

n=input("Enter the String:")

if palindrome(n)== True:
    print("It is a Palindrome")
else:
    print("It is not a Palindrome")


