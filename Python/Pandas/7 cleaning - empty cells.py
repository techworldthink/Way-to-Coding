#Empty cells
#Data in wrong format
#Wrong data
#Duplicates


import pandas as pd

#Empty Cells remove
df = pd.read_csv('data.csv')
new_df = df.dropna()
print(new_df.to_string())


#If you want to change the original DataFrame, use the inplace = True argument:
df.dropna(inplace = True)
print(df.to_string())

#Replace NULL values with the number 130
df = pd.read_csv('data.csv')
df.fillna(130, inplace = True)
print(df.to_string())

#Replace Only For a Specified Columns
df = pd.read_csv('data.csv')
df["Id"].fillna(130, inplace = True)



#Replace Using Mean, Median, or Mode

df = pd.read_csv('data.csv')
x = df["Id"].mean()
df["Id"].fillna(x, inplace = True)
print(df.to_string())

df = pd.read_csv('data.csv')
x = df["Id"].median()
df["Id"].fillna(x, inplace = True)
print(df.to_string())

df = pd.read_csv('data.csv')
x = df["Id"].mode()[0]
df["Id"].fillna(x, inplace = True)
print(df.to_string())














