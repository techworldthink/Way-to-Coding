import pymongo

client = pymongo.MongoClient("mongodb://localhost:27017/") 

print(client.list_database_names())

database = client["CLGE"]
collection = database["STD"]

datas = [{"_id":1,"name":"A","mark":13},
         {"_id":2,"name":"B","mark":14},
         {"_id":3,"name":"C","mark":14},
         {"_id":4,"name":"D","mark":44},
         {"_id":5,"name":"E","mark":54},
         {"_id":6,"name":"F","mark":24},
         {"_id":7,"name":"G","mark":74},
         {"_id":8,"name":"H","mark":64},
         {"_id":9,"name":"I","mark":84},
         {"_id":10,"name":"J","mark":914},
         {"_id":11,"name":"K","mark":154},
         {"_id":12,"name":"L","mark":124},
         {"_id":13,"name":"M","mark":142},
         {"_id":14,"name":"N","mark":154}]

collection.insert_many(datas);
