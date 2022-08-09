import os
from tkinter import font
from tkinter.scrolledtext import ScrolledText
from tkinter import*
import pymongo
import tkinter as tk

client = pymongo.MongoClient("mongodb://localhost:27017/") 

class Convert:
    def __init__(self, master):
        self.master = master
        master.title("Details viewer")
        master.geometry("300x600")
        master.configure(bg="white")

        master.grid_rowconfigure(0, weight=1)
        master.columnconfigure(0, weight=1)
        self.text_color = (0, 0, 0)


        self.frame_left  = LabelFrame(master,text="STUDENT MARKS VIEWER",labelanchor="n",bg="white",bd=2,fg="red")
        self.frame_left.grid(row=0,column=0,sticky="nsew")
        
        # LEFT frame
        self.frame_left.grid_rowconfigure(0, weight=1)
        self.frame_left.grid_rowconfigure(1, weight=1)
        self.frame_left.grid_rowconfigure(2, weight=1)
        self.frame_left.columnconfigure(0, weight=1)
        self.frame_left.columnconfigure(1, weight=1)

        #componants for frame 1
        self.LABEL_LEFT = Label(self.frame_left,text="Names & marks",padx=0,pady=0,bg="white",fg="black",width=10)
        self.ENTRY_LEFT = Entry(self.frame_left,bg="white",fg="green",bd=0)
        self.BOX_LEFT_1 = ScrolledText(self.frame_left,width=5)
        self.BOX_LEFT_2 = ScrolledText(self.frame_left,width=5) 
                
        #componants grid for frame 1
        self.LABEL_LEFT.grid(row=0,column=0,sticky="nsew",columnspan=2)
        self.BOX_LEFT_1.grid(row=1,column=0,sticky="nsew")
        self.BOX_LEFT_2.grid(row=1,column=1,sticky="nsew")
        self.ENTRY_LEFT.grid(row=2,column=0,sticky="ew",columnspan=2)

        #mongoDB
        database = client["CLGE"]
        collection = database["STD"]

        for data in collection.find():
            self.BOX_LEFT_1.insert(tk.INSERT,data["name"]+"\n")
            self.BOX_LEFT_2.insert(tk.INSERT,str(data["mark"])+"\n")
        
       
        
       
root = Tk()
hack_gui = Convert(root)
root.mainloop()
