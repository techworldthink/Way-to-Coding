#python program to find the no of prime numbers in a given file

def prime(number):
    if number == 1 :
        return True
    else :
        for i in range(2, number) :
            if (number % i) == 0 :
                return False
    return True
        

count=0
f=open("prime.txt","r")
for i in map(int,f.readline().split()):
    if prime(i):
        count = count + 1
print(count)


f.close()


