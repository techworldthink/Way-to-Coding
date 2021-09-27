import pymongo

client = pymongo.MongoClient("mongodb://localhost:27017/") 

print(client.list_database_names())

database = client["testDB"]
collection = database["collection_1"]

"""
data = {"_id":1,"name":"A","rollno":12}
datas = [{"_id":2,"name":"B","rollno":13},
         {"_id":3,"name":"C","rollno":14}]

collection.insert_one(data);
collection.insert_many(datas);
"""

print("\n\n ------ All Details ------ \n")
for data in collection.find():
    print(data)
    
print("\n\n ------ Only _id ------ \n")    
for data in collection.find({},{}):
    print(data)
    
print("\n\n ------ _id , name ------ \n")    
for data in collection.find({},{"name":1}):
    print(data)

print("\n\n ------ Only name ------ \n")    
for data in collection.find({},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ WHERE name = \"A\" ------ \n")    
for data in collection.find({"name":{"$eq":"A"}},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ WHERE name != \"A\" ------ \n")    
for data in collection.find({"name":{"$ne":"A"}},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ WHERE rollno > 12 ------ \n")    
for data in collection.find({"rollno":{"$gt":12}},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ WHERE rollno < 14 ------ \n")    
for data in collection.find({"rollno":{"$lt":14}},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ WHERE rollno < 14 && rollno > 12 ------ \n")    
for data in collection.find({"rollno":{"$lt":14,"$gt":12}},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ AND ------ \n")    
for data in collection.find({"$and":[{"rollno":{"$lt":14}},{"rollno":{"$gt":12}}]},{"name":1,"_id":0}):
    print(data)

print("\n\n ------ OR ------ \n")    
for data in collection.find({"$or":[{"rollno":{"$lt":14}},{"rollno":{"$gt":12}}]},{"name":1,"_id":0}):
    print(data)


print("\n\n ------ SORT ASC ------ \n")    
for data in collection.find().sort("name",1):
    print(data)

print("\n\n ------ SORT DESC ------ \n")    
for data in collection.find().sort("name",-1):
    print(data)

print("\n\n ------ REGEX ------ \n")    
for data in collection.find({"name":{"$regex":"^A"}}):
    print(data)

print("\n\n ------ DELETE ONE ------ \n")    
collection.delete_one({"_id":4});

print("\n\n ------ DELETE MANY ------ \n")    
collection.delete_many({"_id":{"$gt":4}});

print("\n\n ------ DROP ------ \n")
collection2 = database["collection_2"]
data2 = {"_id":1,"name":"A","rollno":12}
collection2.insert_one(data2);
for data in collection2.find():
    print(data)
collection2.drop();


print("\n\n ------ SORT ASC & LIMIT ------ \n")    
for data in collection.find().sort("name",1).limit(1):
    print(data)






