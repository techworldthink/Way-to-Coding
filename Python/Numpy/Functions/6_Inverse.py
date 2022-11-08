import numpy as np 

def create_matrix(mc):
    print("\nARRAY "+str(mc)+" Elements : ")
    array_1 = map(int, input().split())
    array_1 = np.array(list(array_1))
    #print(arr)
    print("\nARRAY "+str(mc)+" ,  ROW COLUMN : ")
    row,column = map(int, input().split())
    if(len(array_1)!= (row*column)):
        print("\nRow and Column size not match with total elements !! retry")
        return create_matrix(mc)
    array_1 = array_1.reshape(row,column)
    print("\nARRAY "+str(mc))
    print(array_1)
    print("\nInverse : ")
    return array_1



print(np.linalg.inv(create_matrix(1)))




