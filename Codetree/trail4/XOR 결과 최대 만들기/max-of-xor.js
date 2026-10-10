const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const a = input[1].split(' ').map(Number);

const choose = [] 
var max = 0;

getNum(0);

console.log(max);

function getNum(st){

    if(choose.length == m){
        let answer = choose[0];
        for(let i=1; i<m; i++){
            answer = answer^choose[i];
        }
        max = Math.max(max, answer);
        return;
    }

    for(let i=st; i<n; i++){
        choose.push(a[i]);
        getNum(i+1);
        choose.pop(a[i]);
    }

}