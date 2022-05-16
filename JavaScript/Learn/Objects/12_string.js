// primitive
let message = 'hi';

// internally convert to object 
console.log(message.length);

const msge = new String('hi ok');
console.log(msge.length);


console.log(msge.includes('ok'));
console.log(msge.startsWith('h'));
console.log(msge.endsWith('k'));
console.log(msge.indexOf('k'));
console.log(msge.replace('k','j'));
console.log(msge.toUpperCase());

// remove left and right whitespace
console.log(msge.trim());

console.log(msge.trimLeft());

// escape sequence
message = 'hi i am \'hacker\' ';
console.log(message);