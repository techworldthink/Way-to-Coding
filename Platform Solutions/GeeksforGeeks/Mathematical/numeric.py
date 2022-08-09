a="as1cv20sg6"
a=a+'Z'
sum=0
str=''
for i in a:
    if(i.isnumeric()==True):
        str = str + i
    else:
        if(str!=''):
            sum=sum+int(str)
        str=''
print(sum)
