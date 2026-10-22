const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const n = Number(input[0]);
const num = input.slice(1).map(line => line.split(' ').map(Number));

const square = Array.from({length : n+1}, () => Array(n+1).fill(0));

for(let i=1; i<n+1; i++){
    for(let j=1; j<n+1; j++){
        square[i][j] = num[i-1][j-1];
    }
}

for(let i=1; i<n+1; i++){
    for(let j=1; j<n+1; j++){
        square[i][j] += Math.max(square[i-1][j], square[i][j-1]);
    }
}

console.log(square[n][n]);