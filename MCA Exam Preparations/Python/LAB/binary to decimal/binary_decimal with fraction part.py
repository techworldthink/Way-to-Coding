binary = input("Enter the binary number:")
decimal = fraction = i = fr_len = fr = 0
temp_str = str(binary)
if '.' in temp_str:
    integral = int(temp_str.split('.')[0])
    fr_len = len(temp_str.split('.')[1])
    fr = temp_str.split('.')[1]
else:
    integral = int(temp_str)

while integral!=0:
    decimal += integral%10 * 2**i
    integral//= 10
    i += 1
if(fr_len!=0):
    for i in range(1, fr_len+1):
        fraction += int(fr[i-1]) * 2**(-i)

print("Decimal equivalent: ", decimal+fraction)