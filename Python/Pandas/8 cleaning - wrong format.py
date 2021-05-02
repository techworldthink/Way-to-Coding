import pandas as pd

df = pd.read_csv('date.csv')
df['date'] = pd.to_datetime(df['date'])
print(df.to_string())
