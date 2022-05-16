// reference
const circle = {
    radius: 1
};

const circle1 = circle;
circle.radius = 2;
console.log(circle);
console.log(circle1);

// clone
const circle3 = {
    radius: 1
};


const circle4 = Object.assign({}, circle3);
circle3.radius = 2;
console.log(circle3);
console.log(circle4);
