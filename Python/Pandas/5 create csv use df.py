import pandas as pd
cities = pd.DataFrame([['Sacramento', 'California'], ['Miami', 'Florida']], columns=['City', 'State'])
cities.to_csv('cities.csv', index=False, sep=';')
