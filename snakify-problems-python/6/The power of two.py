i=0
power=1
N=int(input())
while power*2<=N:
    i+=1
    power*=2
print(i,power)