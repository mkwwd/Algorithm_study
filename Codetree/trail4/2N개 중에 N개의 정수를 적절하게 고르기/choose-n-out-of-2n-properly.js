const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const A = input[1].split(' ').map(Number);
const choose = Array(2*n).fill(0);

var answer = 20*1000;

Calculation(0, 0)

console.log(answer);

function Calculation(st, cnt){

    if(cnt == n){
        var sumA = 0;
        var sumB = 0;
        for(let i=0; i<choose.length; i++){
            if(choose[i] == 1){
                sumA += A[i];
            }else{
                sumB += A[i];
            }
        }
        var gap = Math.abs(sumA - sumB);
        answer = Math.min(answer, gap);
        return;
    }

    for(let i=st; i<A.length; i++){
        choose[i] = 1;
        Calculation(i+1, cnt+1);
        choose[i] = 0;
    }
}