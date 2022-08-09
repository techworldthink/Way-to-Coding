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
