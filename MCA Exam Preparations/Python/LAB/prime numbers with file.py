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

f=open("file1.txt","r")
f1=open("prime.txt","w")
for i in map(int,f.readline().split( )):
    if prime(i):
        f1.write(str(i)+' ')

f.close()
f1.close()

