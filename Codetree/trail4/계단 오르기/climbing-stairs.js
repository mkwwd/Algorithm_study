const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);

const stairs = [];

stairs.push(0);
stairs.push(0);
stairs.push(1);
stairs.push(1);

for(let i=4; i<n+1; i++){
    var cnt = (stairs[i-2] + stairs[i-3])%10007;
    stairs.push(cnt);
}

console.log(stairs[n]);