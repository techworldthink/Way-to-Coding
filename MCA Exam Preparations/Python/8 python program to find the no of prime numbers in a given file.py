#python program to find the no of prime numbers in a given file

def prime(number):
    conclusion=0
    if number == 1 :
        conclusion = 0
        return True
    else :
        for i in range(2, number) :
            if (number % i) == 0 :
                conclusion = 1
                break
            else:
                conclusion =0
        if conclusion == 0:
            return True
        else:
            return False


f=open("prime.txt","r")
for i in map(int,f.readline().split()):
    if prime(i):
        print(i)


f.close()


