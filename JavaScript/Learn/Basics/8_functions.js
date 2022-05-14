// without parameters
function greet(){
    console.log("Hello world!");
}

// with parameters(argument)
function greetPerson(name){
    console.log("Hello " + name);
}

function greetPersonReturn(name){
    return "Hello " + name;
}


greet();
greetPerson("World");
console.log(greetPersonReturn("World.."));