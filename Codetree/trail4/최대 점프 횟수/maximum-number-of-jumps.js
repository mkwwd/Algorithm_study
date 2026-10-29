const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input[1].trim().split(' ').map(Number);

const dp = Array(n).fill(0);
var max = 0;

for(let i=0; i<n; i++){
    max = Math.max(max, dp[i]);
    var jump = arr[i];
    if(jump == 0) continue;
    if(i != 0 && dp[i] == 0) continue;
    for(let j=1; j<=jump; j++){
        dp[i+j] = Math.max(dp[i+j], dp[i]+1);
    }
}

console.log(max)