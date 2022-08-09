def prime(number):
    conclusion=0
    if number == 1 :
        conclusion = 0
        print(number)
    else :
        for i in range(2, number) :
            if (number % i) == 0 :
                conclusion = 1
                break
            else:
                conclusion =0
        if conclusion == 0:
            print(number)

start=int(input("Enter starting point : "))
stop=int(input("Enter stopping point : "))
for i in range(start,stop):
    prime(i)
