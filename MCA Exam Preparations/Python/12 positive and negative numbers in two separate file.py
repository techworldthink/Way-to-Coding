"""
12. Write a python program to read numbers from a file and
store positive and negative numbers in two separate files.
"""

def main():
    file = open("12_sample.txt","r")
    file_p = open("12_positive.txt","w")
    file_n = open("12_negative.txt","w")

    for each in file.readline().split():
        if(each.find(".") >= 0):
            each_f = float(each)
            if(each_f>0):
                file_p.write(str(each)+" ")
            else:
                file_n.write(str(each)+" ")
        else:
            each_i = int(each)
            if(each_i>0):
                file_p.write(str(each)+" ")
            else:
                file_n.write(str(each)+" ")
     

    file.close()
    file_p.close()
    file_n.close()
        
main()
