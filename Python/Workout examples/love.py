import random

success=False

def breake():
    print("Try Another !!!")
    
def status():
    status_list = ["committed","not interested","not you"]
    interest = random.randint(0,2)
    return status_list[interest] 

def accept():
    isaccept = ["True","False"]
    interest = random.randint(0,1)
    if isaccept[interest] == "True":
        return True
    else:
        return False

def fix(name):
    print("you were trapped in ",name)

def ask_in_house():
    isok = ["True","False"]
    permission = random.randint(0,1)
    if isok[permission] == "True":
        print("you are a succesfull person")
    else:
        print("decision pending")
        
def propose(name):
    try:
        if accept():
            fix(name)
            ask_in_house()
            global success
            success=True
        else:
            state = status()
            if state == "committed":
                breake()
            else:
                propose(name)
    except:
        print("You can't  !!!")

while(not success):
    name = input("Propose : ")
    propose(name)
