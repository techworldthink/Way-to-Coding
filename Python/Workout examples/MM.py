#Arithmetic Mean and Median of given no’s
a = []
print("Enter the Numbers and then press ENTER: ")
while True:
    numbers = input()
    if not numbers:
        average=round(sum(a)/len(a),2)
        print ("average is :",average)
        break
    else:
        a.append(float(numbers))
print()
#to find median
M = sorted(a)
print(M)
print()
if len(M)%2==0:
    i=int(len(M)/2)
    Median=(M[i-1]+M[i])/2
else:
    i=int((len(M)+1)/2)
    Median=M[i-1]
print("Median is",Median)
print()
