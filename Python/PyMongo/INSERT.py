import pymongo

# Data
data = {"id":12,"type":"BLE","data":"ok"}
datas = [{"id":13,"type":"BLE","data":"ok"},
         {"id":14,"type":"BLE","data":"Error"},
         {"_id":1,"id":15,"type":"IR","data":"none"},
         ]

# Establish Connection
client = pymongo.MongoClient("mongodb://localhost:27017/")
# List all Databases
print(client.list_database_names())

# Select your databse
if "TESTING" in client.list_database_names():
    myDb = client["TESTING"]
    if "DATA" in myDb.list_collection_names():
        myCollection = myDb["DATA"]
        _id = myCollection.insert_one(data)
        print("ID Of Inserted document "+ str(_id.inserted_id))
        _ids = myCollection.insert_many(datas)
        print("ID Of Inserted documents ")
        print(_id.inserted_id)
    else:
        print("Collection not exists!")
else:
    print("DB not exists!")


