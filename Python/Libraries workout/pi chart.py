import matplotlib.pyplot as plt

# Data to plot
labels = 'Food','Saving','Entertainment','Transportation','Cloths','Bills'
sizes = [15000,15000,20000,15000,3500,5000]
colors = ['gold', 'yellowgreen', 'lightcoral', 'lightskyblue','lightpink','orange']
explode = (0.1, 0, 0, 0,0,0)  # explode 1st slice

# Plot
plt.pie(sizes, explode=explode, labels=labels, colors=colors,
autopct='%1.1f%%', shadow=True, startangle=140)

plt.axis('equal')
plt.show()
