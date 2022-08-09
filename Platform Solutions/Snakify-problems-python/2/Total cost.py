A=int(input("cost of one cake in dollars"))
B=int(input("cost of one cake in cents"))
N=int(input("total no. of cakes"))
c=N*B//100
d=N*B%100
print(N*A+c,d)