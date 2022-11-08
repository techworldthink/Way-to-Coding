from sklearn.datasets import load_iris
from sklearn import metrics
from sklearn import tree
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier

iris=load_iris()
x=iris.data
y=iris.target
x_train,x_test,y_train,y_test = train_test_split(x,y,test_size=0.3,random_state=1)

clf=DecisionTreeClassifier()
clf=clf.fit(x_train,y_train)
y_pred=clf.predict(x_test)
print("Accuracy: ",metrics.accuracy_score(y_test,y_pred))

plt.figure(figsize=(15,15))
tree.plot_tree(clf,fontsize=10,filled=True,rounded=True,class_names=iris.target_names,feature_names=iris.feature_names)
plt.show()
