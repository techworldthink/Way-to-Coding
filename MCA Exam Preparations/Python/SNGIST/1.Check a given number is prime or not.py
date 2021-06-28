#1.Check a given number is prime or not

def prime(number):
    conclusion=0
    if number == 1 :
        conclusion = 0
    else :
        for i in range(2, (number//2)+1):
            if (number % i) == 0 :
                conclusion = 1
                break
            else:
                conclusion =0
    if conclusion == 0: print("Prime")
    else: print("Not prime")
            
def main():
    number = int(input("Enter a number : "))
    prime(number)
    
while(True):    
    main()
