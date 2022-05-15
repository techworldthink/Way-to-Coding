const person = {
    name: 'myname',
    age: 33
};

for (let key in person)
    console.log(key);

for (let key in person)
    console.log(person[key]);

console.log(person.name);
console.log(person['age']);



const colors = ['red', 'green'];

for (let index in colors) 
    console.log(index);
