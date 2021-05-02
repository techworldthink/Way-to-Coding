import pandas as pd

df = pd.read_csv('data.csv')

print(df.head(2))
print(df.head()) #defualt 5 row
print(df.tail()) 
print(df.info())
