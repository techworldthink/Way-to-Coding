const circle = {
    radius: 1
};


for (let key in circle)
    console.log(key, circle[key]);


for (let key of Object.keys(circle))
    console.log(key);

for (let entry of Object.entries(circle))
    console.log(entry);

if ('radius' in circle) console.log('yes');