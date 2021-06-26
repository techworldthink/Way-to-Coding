def main():
    file = open("sample.txt","r")
    file_list =  file.readline().split()
    file_min_list  =  list(set(file_list))
    file_min_list.sort()

    for each in file_min_list:
        print(each," : ",file_list.count(each))

    file.close()
    
main()
