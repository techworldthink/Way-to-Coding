import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]


# Sort

#ascending
for data in myCollection.find().sort("type",1):
    print(data)
#descending
for data in myCollection.find().sort("type",-1):
    print(data)




