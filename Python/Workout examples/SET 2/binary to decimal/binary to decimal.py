def bin_dec(bin):
    dec = 0
    count_sqaure =0 
    string = str(bin)
    for i in string:
        if (int(i)!=1) and (int(i)!=0):
            return "Not a binary"
        else:
            continue
    string = string[::-1]
    for i in string:
        dec += int(i)*(pow(2,count_sqaure))
        count_sqaure +=1
    return dec


bin = int(input("Enter a binay number  : "))
print(bin_dec(bin))

