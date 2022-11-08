list=[]
while True:
    try:
        get_value=input("Enter a number :")
        if get_value=="done":
            print("Invalid input")
            print("Maximum is ",max(list))
            print("Minimum is ",min(list))
            break
        else:
            get_value=int(get_value)
            list.append(get_value)
    except:
        print("Invalide Input")
