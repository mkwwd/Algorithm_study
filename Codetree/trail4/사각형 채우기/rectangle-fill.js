const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);

const square = [];

square.push(0);
square.push(1);
square.push(2);

for(let i=3; i<n+1; i++){
    square.push((square[i-1] + square[i-2])%10007)
}

console.log(square[n])