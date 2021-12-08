from tkinter.ttk import *
from tkinter import*
from tkinter import font
from tkinter import messagebox
from PIL import Image, ImageDraw, ImageFont,ImageTk
import PIL.Image
from tkinter.scrolledtext import ScrolledText
import tkinter as tk

decision_counter = 0

root = Tk()

class Convert:
    def __init__(self, master):
        self.master = master
        master.title("Single Button Event")
        master.geometry("1000x200")
        master.configure(bg="white")

        # Demo model certificate
        model = PIL.Image.open("0.png")
        newsize = (300, 300)
        model = model.resize(newsize)
        IMG_STATUS = ImageTk.PhotoImage(model)

                
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
        self.frame_left     =  LabelFrame(master,text="ON/OFF",labelanchor="n",bg="white",bd=10,fg="red",font=self.label_frame_font)
        self.frame_right    =  LabelFrame(master,text="LOGS",labelanchor="n",bg="white",bd=10,fg="red",font=self.label_frame_font)

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
        #componants for frame 1  
        self.frame2_btn = Button(self.frame_left,image=IMG_STATUS,text="Calculate",height = 300, width = 300,command=lambda:activate())
        self.frame2_btn.image=IMG_STATUS
        #componants grid for frame 1
        self.frame2_btn.grid(row=1,column=1)


        #frame for componants for fisrt labeled frame  row configure  2
        self.frame_right.grid_rowconfigure(0, weight=1)   
        self.frame_right.columnconfigure(0, weight=1)
        #componants for frame 2
        self.scroll_text = ScrolledText(self.frame_right,bg="white",fg="green")
        #componants grid for frame 2
        self.scroll_text.grid(row=0,column=0)
                      
        self.scroll_text.insert(tk.INSERT,"-------------LOGS----------\nStarting...")

        


        def activate():
            global decision_counter
            
            if(decision_counter == 0):
                model = PIL.Image.open("1.png")
                self.scroll_text.insert(tk.INSERT,"\nListening...")
                decision_counter=1
            else:
                model = PIL.Image.open("0.png")
                self.scroll_text.insert(tk.INSERT,"\n!!! OFF !!!")
                decision_counter=0
                
            newsize = (300, 300)
            model = model.resize(newsize)
            IMG_STATUS = ImageTk.PhotoImage(model)
            self.frame2_btn = Button(self.frame_left,image=IMG_STATUS,text="Calculate",height = 300, width = 300,command=lambda:activate())
            self.frame2_btn.image=IMG_STATUS
            self.frame2_btn.grid(row=1,column=1)
            
            




hack_gui = Convert(root)
root.mainloop()
