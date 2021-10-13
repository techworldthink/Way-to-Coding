from tkinter import*

# initial set

calc_app=Tk()
calc_app.resizable(0,0)
calc_app.title("Python Calculator")
calc_app.geometry("300x600")
calc_app.configure(bg="black")


#Grid configure

calc_app.grid_rowconfigure(0, weight=1)
calc_app.grid_rowconfigure(1, weight=1)
calc_app.grid_rowconfigure(2, weight=1)
calc_app.grid_rowconfigure(3, weight=1)
calc_app.grid_rowconfigure(4, weight=1)
calc_app.grid_rowconfigure(5, weight=1)
calc_app.grid_rowconfigure(6, weight=1)
calc_app.grid_columnconfigure(0, weight=1)
calc_app.grid_columnconfigure(1, weight=1)
calc_app.grid_columnconfigure(2, weight=1)

# Calculations

expression = "" 
equation = StringVar()

def press(num):
    global expression 
    expression = expression + str(num) 
    equation.set(expression)
def equalpress():
   global expression
   total = str(eval(expression)) 
   equation.set(total)
   expression=total
def clear():
    global expression
    expression=""
    equation.set(expression)
    
    
# widgets set

text_box_main = Entry(calc_app, textvariable=equation) 
button_1=Button(calc_app,width=10,height=3,text="1",command=lambda:press(1))
button_2=Button(calc_app,width=10,height=3,text="2",command=lambda:press(2))
button_3=Button(calc_app,width=10,height=3,text="3",command=lambda:press(3))
button_4=Button(calc_app,width=10,height=3,text="4",command=lambda:press(4))
button_5=Button(calc_app,width=10,height=3,text="5",command=lambda:press(5))
button_6=Button(calc_app,width=10,height=3,text="6",command=lambda:press(6))
button_7=Button(calc_app,width=10,height=3,text="7",command=lambda:press(7))
button_8=Button(calc_app,width=10,height=3,text="8",command=lambda:press(8))
button_9=Button(calc_app,width=10,height=3,text="9",command=lambda:press(9))

button_0=Button(calc_app,width=10,height=3,text="0",command=lambda:press(0))
button_plus=Button(calc_app,width=10,height=3,text="+",command=lambda:press("+"))
button_minus=Button(calc_app,width=10,height=3,text="-",command=lambda:press("-"))
button_mul=Button(calc_app,width=10,height=3,text="x",command=lambda:press("*"))
button_div=Button(calc_app,width=10,height=3,text="/",command=lambda:press("/"))
button_dec=Button(calc_app,width=10,height=3,text=".",command=lambda:press("."))
button_equal=Button(calc_app,width=10,height=3,text="=",command=lambda:equalpress())
button_clr=Button(calc_app,width=10,height=3,text="CLR",command=lambda:clear())
button_exit=Button(calc_app,width=10,height=3,text="Exit",command=lambda:exit())


# Grid alignment

text_box_main.grid(columnspan=3,padx=2,pady=2, ipadx=300,sticky="nsew")

button_1.grid(row=2,column=0,sticky="nsew")
button_2.grid(row=2,column=1,sticky="nsew")
button_plus.grid(row=2,column=2,sticky="nsew")

button_3.grid(row=3,column=0,sticky="nsew")
button_4.grid(row=3,column=1,sticky="nsew")
button_minus.grid(row=3,column=2,sticky="nsew")

button_5.grid(row=4,column=0,sticky="nsew")
button_6.grid(row=4,column=1,sticky="nsew")
button_mul.grid(row=4,column=2,sticky="nsew")

button_7.grid(row=5,column=0,sticky="nsew")
button_8.grid(row=5,column=1,sticky="nsew")
button_div.grid(row=5,column=2,sticky="nsew")

button_9.grid(row=6,column=0,sticky="nsew")
button_0.grid(row=6,column=1,sticky="nsew")
button_equal.grid(row=6,column=2,sticky="nsew")

button_dec.grid(row=7,column=0,sticky="nsew")
button_clr.grid(row=7,column=1,sticky="nsew")
button_exit.grid(row=7,column=2,sticky="nsew")

calc_app.mainloop()
