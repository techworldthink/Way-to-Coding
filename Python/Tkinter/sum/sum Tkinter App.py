from tkinter.ttk import *
from tkinter import*
from tkinter import font
from tkinter import messagebox

class Convert:
    def __init__(self, master):
        self.master = master
        master.title("Simple app")
        master.geometry("1000x200")
        master.configure(bg="white")

        ButtonVar1 = StringVar() 
        ButtonVar2 = StringVar()
        
        #full window row configure
        master.grid_rowconfigure(0, weight=1)
   
        #full window column configure
        master.columnconfigure(0, weight=1)
      
        #Fonts
        self.label_frame_font = font.Font(family="Helvetica",size=10,weight="bold")
        self.frame2_font = font.Font(family="Franklin Gothic Medium",size=10)

        #labelled frames
        self.frame_left  =  LabelFrame(master,text="SUM",labelanchor="n",bg="white",bd=10,fg="red",font=self.label_frame_font)
      
         #frame grids
        self.frame_left.grid(row=0,column=0,sticky="nsew")
   
        #frame for componants for fisrt labeled frame  row configure  1
        self.frame_left.grid_rowconfigure(0, weight=1)
        self.frame_left.grid_rowconfigure(1, weight=1)
        self.frame_left.grid_rowconfigure(2, weight=1)
        
        self.frame_left.columnconfigure(0, weight=1)
        self.frame_left.columnconfigure(1, weight=1)
        self.frame_left.columnconfigure(2, weight=1)
        self.frame_left.columnconfigure(3, weight=1)
        self.frame_left.columnconfigure(4, weight=1)

        #componants for frame 1
        self.label_frame_2 = Label(self.frame_left,text="Input",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.label2_frame_2 = Label(self.frame_left,text="Output",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.entry_frame_2 = Entry(self.frame_left,bg="white",fg="black",textvariable = ButtonVar1)
        self.entry2_frame_2 = Entry(self.frame_left,bg="white",fg="black",textvariable = ButtonVar2)
       
        self.frame2_btn = Button(self.frame_left,text="Calculate",height = 1, width = 8,bg="#d1d1d1",fg="black",command=lambda:find_sum())

        #componants grid for frame 1
        self.label_frame_2.grid(row=0,column=1,sticky="w")
        self.entry_frame_2.grid(row=1,column=1,sticky="w",padx=10,pady=10)
        self.label2_frame_2.grid(row=0,column=3,sticky="w")
        self.entry2_frame_2.grid(row=1,column=3,sticky="w",padx=10,pady=10)
        self.frame2_btn.grid(row=2,column=2)

        #define functions here
        def find_sum():
            min = int(ButtonVar1.get())
            self.entry2_frame_2.delete(0, 'end')
            self.entry2_frame_2.insert(0,str(min+10))
            print(min)
       
root = Tk()
hack_gui = Convert(root)
root.mainloop()
