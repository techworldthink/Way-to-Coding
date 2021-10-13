from tkinter.ttk import *
from tkinter import*
from tkinter import font
from tkinter import messagebox

class Convert:
    def __init__(self, master):
        self.master = master
        master.title("INR-US Converter App")
        master.geometry("1000x200")
        master.configure(bg="white")

        ButtonVar1 = StringVar() 
        ButtonVar2 = StringVar()
        ButtonVar3 = StringVar() 
        ButtonVar4 = StringVar()

        
        
        #full window row configure
        master.grid_rowconfigure(0, weight=1)
   
        #full window column configure
        master.columnconfigure(0, weight=1)
        master.columnconfigure(1, weight=1)

        
        #Fonts
        self.label_frame_font = font.Font(family="Helvetica",size=10,weight="bold")
        self.frame2_font = font.Font(family="Franklin Gothic Medium",size=10)

        # MENU SECTION STARTED #####################################################
        self.menu_section = Menu(master)                                                                 # menu started
        self.menu_section_file = Menu(self.menu_section,tearoff = 0)                          # file menu option
        self.menu_section_file.add_command(label="About")
        self.menu_section_file.add_command(label="close")
        self.menu_section_file.add_separator()                                                            #menu option seperator
        self.menu_section_file.add_command(label="Exit")
        master.config(menu = self.menu_section)                                                         # file menu configure with the menu_section
        self.menu_section.add_cascade(label="File", menu = self. menu_section_file)   #menu label

        #END MENU #####################################################################

        #labelled frames
        self.frame_left          =  LabelFrame(master,text="INR to US Dollar",labelanchor="n",bg="white",bd=10,fg="red",font=self.label_frame_font)
        self.frame_right     =  LabelFrame(master,text="US Dollar to INR",labelanchor="n",bg="white",bd=10,fg="red",font=self.label_frame_font)

         #frame grids
        self.frame_left.grid(row=0,column=0,sticky="nsew")
        self.frame_right.grid(row=0,column=1,sticky="nsew")


        #frame for componants for fisrt labeled frame  row configure  1
        self.frame_left.grid_rowconfigure(0, weight=1)
        self.frame_left.grid_rowconfigure(1, weight=1)
        self.frame_left.grid_rowconfigure(2, weight=1)
        
        self.frame_left.columnconfigure(0, weight=1)
        self.frame_left.columnconfigure(1, weight=1)
        self.frame_left.columnconfigure(2, weight=1)
        self.frame_left.columnconfigure(3, weight=1)
        self.frame_left.columnconfigure(4, weight=1)

        #frame for componants for fisrt labeled frame  row configure  2
        self.frame_right.grid_rowconfigure(0, weight=1)
        self.frame_right.grid_rowconfigure(1, weight=1)
        self.frame_right.grid_rowconfigure(2, weight=1)
        
        self.frame_right.columnconfigure(0, weight=1)
        self.frame_right.columnconfigure(1, weight=1)
        self.frame_right.columnconfigure(2, weight=1)
        self.frame_right.columnconfigure(3, weight=1)
        self.frame_right.columnconfigure(4, weight=1)
        
        

        

        #componants for frame 1
        self.label_frame_2 = Label(self.frame_left,text="INR",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.label2_frame_2 = Label(self.frame_left,text="USD",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.entry_frame_2 = Entry(self.frame_left,bg="white",fg="black",textvariable = ButtonVar1)
        self.entry2_frame_2 = Entry(self.frame_left,bg="white",fg="black",textvariable = ButtonVar2)
       
        self.frame2_btn = Button(self.frame_left,text="Calculate",height = 1, width = 8,bg="#d1d1d1",fg="black",command=lambda:INRtoUS())

        #componants grid for frame 1
        self.label_frame_2.grid(row=0,column=1,sticky="w")
        self.entry_frame_2.grid(row=1,column=1,sticky="w",padx=10,pady=10)
        self.label2_frame_2.grid(row=0,column=3,sticky="w")
        self.entry2_frame_2.grid(row=1,column=3,sticky="w",padx=10,pady=10)
        self.frame2_btn.grid(row=2,column=2)

        #componants for frame 2
        self.label_frame_3 = Label(self.frame_right,text="USD",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.label2_frame_3 = Label(self.frame_right,text="INR",padx=10,pady=10,bg="white",fg="black",font=self.frame2_font)
        self.entry_frame_3 = Entry(self.frame_right,bg="white",fg="black",textvariable = ButtonVar3)
        self.entry2_frame_3 = Entry(self.frame_right,bg="white",fg="black",textvariable = ButtonVar4)
       
        self.frame3_btn = Button(self.frame_right,text="Calculate",height = 1, width = 8,bg="#d1d1d1",fg="black",border=2,command=lambda:UStoINR())

        #componants grid for frame 2
        self.label_frame_3.grid(row=0,column=1,sticky="w")
        self.entry_frame_3.grid(row=1,column=1,sticky="w",padx=10,pady=10)
        self.label2_frame_3.grid(row=0,column=3,sticky="w")
        self.entry2_frame_3.grid(row=1,column=3,sticky="w",padx=50,pady=20)
        self.frame3_btn.grid(row=2,column=2)

        self.entry_frame_2.insert(0,0)
        self.entry_frame_3.insert(0,0)


        def INRtoUS():
            dollar = 73.7749
            min  = 0
            min = int(ButtonVar1.get())
            self.entry2_frame_2.delete(0, 'end')
            self.entry2_frame_2.insert(0,str(min/dollar))
            print(min)
            
        def UStoINR():
            dollar = 73.7749
            min = int(ButtonVar3.get())
            self.entry2_frame_3.delete(0, 'end')
            self.entry2_frame_3.insert(0,str(min*dollar))
            print(min)





root = Tk()
hack_gui = Convert(root)
root.mainloop()
