f_33=open("19_file33.txt","r")
vowels_33=0
for i in (f_33.readline()):
    if(i=='a' or i=='e' or i=='i' or i=='o' or i=='u' or i=='A' or i=='E' or i=='I' or i=='O' or i=='U'):
        vowels_33=vowels_33+1
print("number of vowels are:")
print(vowels_33)
f_33.close()
