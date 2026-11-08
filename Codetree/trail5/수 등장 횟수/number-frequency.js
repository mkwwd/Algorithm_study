const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);
const queries = input[2].split(' ').map(Number);

const map = new Map();

for(let i=0; i<arr.length; i++){
    if(map.has(arr[i])){
        map.set(arr[i], map.get(arr[i])+1);
    }else{
        map.set(arr[i], 1);
    }
}

var answer = "";

for(let i=0; i<queries.length; i++){
    if(map.has(queries[i])){
        answer = answer + map.get(queries[i]) +" ";
    }else{
        answer = answer + "0" + " ";
    }
}

console.log(answer);