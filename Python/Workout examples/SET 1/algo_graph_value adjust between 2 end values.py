data = [54,34,232,2,323,33,4]
#data = [98,42,55,61,25,12]

def is_sorted(data):
    for i in range(len(data)-2):
        if(data[i]<data[i+1]):
            return False
    return True
        

def average(num_1,num_2,num_3):
    #print(num_1,num_2,num_3,(num_1+num_2+num_3)/3)
    return int((num_1+num_2+num_3)/3)

def adjust(data):
    length = len(data)-2
    print("Initial Data : " , data)
    for i in range(len(data)-2):
        data.insert(i+1,average(data[i],data[i+1],data[i+2]))
        if(i != len(data)-1):
            del data[i+length-i]
        #print(data)
        
    print(data)

def main(data):
    while not is_sorted(data):
        adjust(data)


main(data)


"""
data = [98,42,55,61,25,12]

def average(num_1,num_2,num_3):
    print(num_1,num_2,num_3,(num_1+num_2+num_3)/3)
    return int((num_1+num_2+num_3)/3)

def main(data):
    print("Initial Data : " , data)
    for i in range(len(data)-2):
        data[i+1] = average(data[i],data[i+1],data[i+2])

    print(data)


main(data)
"""
