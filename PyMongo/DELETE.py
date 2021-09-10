import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]




print("\nBefore Delete\n")
myCollection.delete_one({"_id" : 1})
for data in myCollection.find():
    print(data)

print("\nAfter Delete\n")
myCollection.delete_many({"data" :{"$regex":"^E"}})
for data in myCollection.find():
    print(data)

print("\nDelete All\n")
myCollection.delete_many({})
for data in myCollection.find():
    print(data)
