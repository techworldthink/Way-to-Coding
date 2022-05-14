/* Falsy Values */
// undefined
// null
// 0
// false
// ''
// NaN
/* others are Truthy */


// short-circuiting (return first truthy value)
console.log(false || 1 || 2);


// use case
let userColor = 'red';
let defaultColor = 'blue';
let currentColor = userColor || defaultColor;
console.log(currentColor);