import module_ul_count as ul

get_string = input("Enter a string : ")
values = ul.count_case(get_string)
print("Count of  Uppercase : ",values[0])
print("Count of  Lowercase : ",values[1])
