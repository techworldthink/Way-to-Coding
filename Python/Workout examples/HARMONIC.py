# This is a program to compute the
# sums of reciprocals of natural numbers
n = int(input("Type number : "))
a = 1
for i in range(2, n+1):
    a = a + 1/i
print(a)
