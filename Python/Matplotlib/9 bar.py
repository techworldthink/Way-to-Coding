import matplotlib.pyplot as plt
import numpy as np

x = np.array(["A", "B", "C", "D"])
y = np.array([3, 8, 1, 10])

plt.bar(x,y)
plt.show()

plt.barh(x, y)
plt.show()

plt.bar(x, y, color = "red")
plt.show()

plt.bar(x, y, width = 0.1)
plt.show()
