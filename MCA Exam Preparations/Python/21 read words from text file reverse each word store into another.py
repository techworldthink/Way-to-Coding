f1=open("21_sample.txt","r")
f2=open("21_output.txt","w")

for i in (f1.readline().split()):
    f2.write(i[::-1]+" ")

f1.close()
f2.close()
