import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]


# filter

print("\nDocument with _id = 1\n")
for data in myCollection.find({"_id":1}):
    print(data)

print("\nDocument with id > 1\n")
for data in myCollection.find({"id":{"$gte":1}}):
    print(data)

print("\nDocument with data field value starts with ^o")
for data in myCollection.find({"data":{"$regex":"^o"}}):
    print(data)


