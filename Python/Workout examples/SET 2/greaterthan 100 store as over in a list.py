N = int(input("Total numbers : "))
listed=[]
for i in range(N):
    num = input("Enter integers")
    if int(num)>100:
        num="over"
    listed.append(num)
print(listed)
