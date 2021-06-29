# 9.Write a Python program to read a list consisting of integers,
# floating point numbers and strings. Separate them into different lists
# depending on the data.

def main():
    data = [1,2,3,.3,3.2,"hai","hallo"]
    integer_data = []
    float_data   = []
    string_data  = []

    for each in data:
        if(isinstance(each, int)):
            integer_data.append(each)
        elif(isinstance(each,float)):
            float_data.append(each)
        elif(isinstance(each, str)):
            string_data.append(each)

    print(integer_data)
    print(float_data)
    print(string_data)
    
main()
