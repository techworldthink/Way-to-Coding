# c*180/100 = f-32 where c is temperature in celsius # and f is temperature in fahrenheit
x = float(input("Enter temperature for conversion: "))
c = ( 5/9 )*( x - 32 )
f = ( ( 9/5 )*x ) + 32
print(x,"C = ",f,"F, and ",x,"F = ",c,"C")
print()
