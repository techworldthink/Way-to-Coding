var n:number = 5 

while(n > 5) { 
   console.log("Entered while") 
} 


do { 
   console.log("Entered do…while") 
} 
while(n>5)



var num:number = 0
var count:number = 0;

for(num=0;num<=20;num++) {
   if (num % 2==0) {
      continue
   }
   count++
}
console.log (" The count of odd values between 0 and 20 is: "+count)    //outputs 10 