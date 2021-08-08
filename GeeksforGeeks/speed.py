"""def calspeed(n1,n2,x):
    sn1=x
    sn2=0
    seconds=0
    if(n1>n2):
        return -1
    else:
        while(seconds<1000):
            if(sn1<sn2):
                return seconds
            sn1=sn1+n1
            sn2=sn2+n2
            seconds=seconds+1
        return -1

print(calspeed(3,4,4))"""

def calspeed(n1,n2,x):
    sn1=x
    sn2=0
    seconds=0
    if(n1>n2):
        return -1
    else:
        return int(x/(n2-n1) +1)

print(calspeed(3,4,1))
    
