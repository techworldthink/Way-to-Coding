import pandas as pd

#replace with values
df = pd.read_csv('data.csv')
df.loc[0, 'Id'] = 45
print(df.to_string())

#new column
for x in df.index:
  if df.loc[x, "Id"] > 0:
    df.loc[x ,"ID"] = 120
print(df.to_string())

#Removing Rows
for x in df.index:
  if df.loc[x, "ID"] >= 120:
    df.drop(x, inplace = True)
print(df.to_string())
