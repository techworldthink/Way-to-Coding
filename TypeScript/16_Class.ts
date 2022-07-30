class Car { 
    //field 
    engine:string; 
    
    //constructor 
    constructor(engine:string) { 
       this.engine = engine 
    }  
    
    //function 
    disp():void { 
       console.log("Function displays Engine is  :   "+this.engine) 
    } 
 } 
 
 //create an object 
 var obj1 = new Car("XXSY1")
 
 //access the field 
 console.log("Reading attribute value Engine as :  "+obj1.engine)  
 
 //access the function
 obj1.disp()