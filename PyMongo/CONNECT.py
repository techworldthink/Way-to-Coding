import pymongo


# Establish Connection
client = pymongo.MongoClient("mongodb://localhost:27017/")
# List all Databases
print(client.list_database_names())




