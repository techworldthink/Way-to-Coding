import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]


rData = myCollection.drop()
print(rData)
