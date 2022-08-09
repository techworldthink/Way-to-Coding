def main():
    file = open("sample.txt","r")
    print(len(file.readline().split()))
    file.close()
    
main()
