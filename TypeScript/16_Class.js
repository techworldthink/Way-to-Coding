var Car = /** @class */ (function () {
    //constructor 
    function Car(engine) {
        this.engine = engine;
    }
    //function 
    Car.prototype.disp = function () {
        console.log("Function displays Engine is  :   " + this.engine);
    };
    return Car;
}());
//create an object 
var obj1 = new Car("XXSY1");
//access the field 
console.log("Reading attribute value Engine as :  " + obj1.engine);
//access the function
obj1.disp();
