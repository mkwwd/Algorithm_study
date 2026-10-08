const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);

const choose = [];

Combination(0, 0);

function Combination(st, cnt){

    if(cnt == m){
        var answer = [...choose].join(" ");
        console.log(answer);
        return;
    }

    for(let i=st; i<n; i++){
        choose.push(i+1);
        Combination(i+1, cnt+1);
        choose.pop();
    }
}