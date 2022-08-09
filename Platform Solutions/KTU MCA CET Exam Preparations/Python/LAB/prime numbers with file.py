def prime(number):
    if number == 1 :
        return True
    else :
        for i in range(2, number) :
            if (number % i) == 0 :
                return False

        return True


f=open("file1.txt","r")
f1=open("prime.txt","w")
for i in map(int,f.readline().split( )):
    if prime(i):
        f1.write(str(i)+' ')

f.close()
f1.close()

