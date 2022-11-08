def count_case(get_string):
    cap = 0
    low = 0
    for each in get_string:
        if each.isupper():
            cap +=1
        elif each.islower():
            low +=1
        else:
            continue
    return cap,low

get_string = input("Enter a string : ")
values = count_case(get_string)
print("Count of  Uppercase : ",values[0])
print("Count of  Lowercase : ",values[1])
