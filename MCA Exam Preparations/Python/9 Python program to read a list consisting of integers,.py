# 9.Write a Python program to read a list consisting of integers,
# floating point numbers and strings. Separate them into different lists
# depending on the data.

def main():
    file = open("9_sample.txt","r")
    file_i = open("9_int.txt","w")
    file_f = open("9_float.txt","w")
    file_s = open("9_string.txt","w")

    for each in file.readline().split():
        if each.replace('.', '', 1).isdigit():
            if(each.find(".") < 0):
                file_i.write(str(each)+" ")
            else:
                file_f.write(str(each)+" ")
        elif(isinstance(each, str)):
            file_s.write(str(each)+" ")

    file.close()
    file_i.close()
    file_f.close()
    file_s.close()
    
main()
