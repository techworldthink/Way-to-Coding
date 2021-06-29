f1=open("20_sample.txt","r")
f2=open("20_output.txt","w")
count = 1
sum = 0
pos = 1
for i in (f1.readline().split()):
    if(pos%2==0):
        count = count + 1
        sum = sum + int(i)
    pos = pos + 1

print("Average @ even position number is : ",sum/count)
f2.write(str(sum/count))

f1.close()
f2.close()
