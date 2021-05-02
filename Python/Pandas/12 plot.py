import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('data.csv')
df.plot()
plt.show()

df["Duration"].plot(kind = 'hist')
plt.show()
