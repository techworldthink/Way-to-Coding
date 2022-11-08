# This program computes the total amount,
#given the principal, interest rate
# and number of years
p = int(input("Principal : "))
r = int(input("Rate of interest : "))
n = int(input("Years : "))
a=round(p*(1 + r/100)**n)
i=a-p
print("Amount =",a)
print("Interest =",i)
