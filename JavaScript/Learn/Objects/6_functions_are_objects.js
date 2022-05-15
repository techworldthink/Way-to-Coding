function Circle(radius) {
  this.radius = radius;
  this.draw = function () {
    console.log("draw");
  };
}

// const circle = new Circle(1);

console.log(Circle.name);
console.log(Circle.length);
console.log(Circle.constructor);

const Circle1 = new Function(
  "radius",
  `
  this.radius = radius;
  this.draw = function () {
    console.log("draw");
  };
  `
);

// Circle1.call({},1);
// Circle1.apply({},[1]);
const circle = new Circle1(1);
console.log(circle);


// Circle1.call(1);
//const circle = Circle1(1);
//console.log(circle);