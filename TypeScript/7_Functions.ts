// Optional parameter
function disp_details(id: number, name: string, mail_id?: string) {
   console.log("ID:", id);
   console.log("Name", name);

   if (mail_id != undefined)
      console.log("Email Id", mail_id);
}
disp_details(123, "John");
disp_details(111, "mary", "mary@xyz.com");

// Rest Parameters
function addNumbers(...nums: number[]) {
   var i;
   var sum: number = 0;

   for (i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
   }
   console.log("sum of the numbers", sum)
}
addNumbers(1, 2, 3)
addNumbers(10, 10, 10, 10, 10)

//Default parameters
function calculate_discount(price: number, rate: number = 0.50) {
   var discount = price * rate;
   console.log("Discount Amount: ", discount);
}
calculate_discount(1000)
calculate_discount(1000, 0.30)

// A Simple Anonymous function
var msg2 = function () {
   return "hello world";
}
console.log(msg2())


//  Anonymous function with parameters
var res = function (a: number, b: number) {
   return a * b;
};
console.log(res(12, 2))

//The Function Constructor
var myFunction = new Function("a", "b", "return a * b");
var x2 = myFunction(4, 3);
console.log(x2);


// Recursion
function factorial(number) {
   if (number <= 0) {         // termination case
      return 1; 
   } else {     
      return (number * factorial(number - 1));     // function invokes itself
   } 
}; 
console.log(factorial(6));      // outputs 720 

