interface IPoint { 
    x:number 
    y:number 
 } 
 function addPoints(p1:IPoint,p2:IPoint):IPoint { 
    var x = p1.x + p2.x 
    var y = p1.y + p2.y 
    return {x:x,y:y} 
 } 
 
 //Valid 
 var newPoint = addPoints({x:3,y:4},{x:5,y:1})  
 
 //Error 
 //var newPoint2 = addPoints({x:1},{x:4,y:3})