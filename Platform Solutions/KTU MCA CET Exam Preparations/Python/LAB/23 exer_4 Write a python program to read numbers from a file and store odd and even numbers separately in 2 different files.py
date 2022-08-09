f=open("file1.txt","r")
f1=open("oddfile.txt","w")
f2=open("evenfile.txt","w")
for i in map(int,f.readline().split( )):
    if i%2!=0:
        f1.write(str(i)+' ')
    else:
        f2.write(str(i)+' ')

f.close()
f1.close()
f2.close()
