#python program to print prime numbers in a given file

def prime(number):
    if number == 1 :
        return True
    else :
        for i in range(2, number) :
            if (number % i) == 0 :
                return False
    return True
      
            
f=open("prime.txt","r")
for i in map(int,f.readline().split()):
    if prime(i):
        print(i)


f.close()


