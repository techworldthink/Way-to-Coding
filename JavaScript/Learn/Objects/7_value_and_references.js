let x = 5;
let y = x;

y = 10;

console.log(x);
console.log(y);

x = { value: 12 };
y = x;

console.log(x.value);
console.log(y.value);

////////////////////////////////

let obj = { value: 12 };
function increse(obj) {
  obj.value++;
}
increse(obj);
console.log(obj);
