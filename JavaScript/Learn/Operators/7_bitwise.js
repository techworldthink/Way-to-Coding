
// 1 = 00000001
// 2 = 00000010
// 3 = 00000011 

console.log(1 | 2);
console.log(1 & 2);


// usecase
// user permissions (like in ubuntu)

const readPermission = 4;
const writePermision = 2;

let myPermission = 0;
myPermission = myPermission | readPermission | writePermision;

let message = (myPermission & readPermission) ? 'yes' : 'No';

console.log(message);