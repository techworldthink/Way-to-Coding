import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]


myCollection.update_one({"data":"Error"},{"$set":{"data":"Invalid"}})

for data in myCollection.find():
    print(data)
    
myCollection.update_many({"data":"ok"},{"$set":{"data":"Invalid"}})
for data in myCollection.find():
    print(data)
