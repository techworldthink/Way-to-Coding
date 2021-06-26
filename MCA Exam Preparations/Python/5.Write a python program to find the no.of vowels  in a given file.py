def main():
    vowels=['a','e','i','o','u','A','E','I','O','U']
    file = open("text_file.txt","r")
    sum=0

    """for line in file:
        print(line,"\n\n")"""
    for line in file:
       for i in vowels:
            sum = sum + line.count(i)
            
    print(sum)

    file.close()
    
main()
