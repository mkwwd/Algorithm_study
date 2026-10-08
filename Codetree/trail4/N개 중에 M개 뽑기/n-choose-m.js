const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);

const choose = Array(n).fill(0);

Combination(0, 0);

function Combination(st, cnt){

    if(cnt == m){
        var answer = "";
        for(let i=0; i<choose.length; i++){
            if(choose[i] == 1){
                answer = answer + (i+1) + " ";
            }
        }
        console.log(answer);
        return;
    }

    for(let i=st; i<choose.length; i++){
        choose[i] = 1;
        Combination(i+1, cnt+1);
        choose[i] = 0;
    }
}