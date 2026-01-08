const list = new Map();
const sale = new Map();
var answer = 0;

function solution(want, number, discount) {
   
    for(let i=0; i<want.length; i++){
        list.set(want[i], number[i]);
    }
    
    for(let i=0; i<10; i++){
        sale.set(discount[i], (sale.get(discount[i]) ?? 0) + 1);
    }
    
    checkWant(want);
    
    for(let i=10; i<discount.length; i++){
        sale.set(discount[i-10], sale.get(discount[i-10]) -1);
        sale.set(discount[i], (sale.get(discount[i]) ?? 0) + 1);
        checkWant(want);
    }
    
    return answer;
}

function checkWant(want){
    
    let cnt = 0;
    
    for(let i=0; i<want.length; i++){
        if(list.get(want[i]) <= (sale.get(want[i]) ?? 0)) cnt++;
    }

    if(cnt == want.length) answer++;
    
}