let a = 10;
let i = 0;

while (i < a) {
    if (i < 4) {
        i++
        continue;
    }
    
    if(i==7){
        break;
    }

    console.log(i);
    i++;
}