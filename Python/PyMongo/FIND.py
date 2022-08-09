import pymongo


client = pymongo.MongoClient("mongodb://localhost:27017/")

myDb = client["TESTING"]
myCollection = myDb["DATA"]

# get one document
data = myCollection.find_one()
print(data)

# get all document
for data in myCollection.find():
    print(data)

"""
You get an error if you specify both 0 and 1 values
in the same object (except if one of the fields
is the _id field)
"""
# get specific document fields (exclude id field)
for data in myCollection.find({},{"id":0}):
    print(data)
# get specific document fields (exclude _id field)
for data in myCollection.find({},{"_id":0}):
    print(data)
# get specific document fields (include  _id and id field)
for data in myCollection.find({},{"_id":0,"id":1}):
    print(data)
# get specific document fields (include  _id , id and type field)
for data in myCollection.find({},{"_id":0,"id":1,"type":1}):
    print(data)


