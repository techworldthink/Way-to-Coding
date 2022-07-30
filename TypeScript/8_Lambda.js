// 1
var foo = function (x) { return 10 + x; };
console.log(foo(100)); //outputs 110 
// 2
var foo2 = function (x) {
    x = 10 + x;
    console.log(x);
};
foo2(100);
