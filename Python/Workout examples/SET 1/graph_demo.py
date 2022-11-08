import matplotlib.pyplot as plt; plt.rcdefaults()
import numpy as np
import matplotlib.pyplot as plt

objects = ('GREEN', 'BLUE', 'YELLOW', 'RED', 'WHITE')
y_pos = np.arange(len(objects))

performance = [219,234,199,31,30]

plt.bar(y_pos, performance, align='center', alpha=1)
plt.xticks(y_pos, objects)


plt.ylabel('SCORE')
plt.title('ARTS PERFORMANCE')

plt.show()
