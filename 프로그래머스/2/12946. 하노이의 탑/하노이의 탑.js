var answer = [];

function solution(n) {
    
    hanoi(n, 1, 2, 3);

    return answer;
}

function hanoi(n, from, ex, to){
    
    if(n == 1){
        answer.push([from, to]);
        return;
    }
    
    hanoi(n-1, from, to, ex);
    
    answer.push([from, to]);
    
    hanoi(n-1, ex, from, to);
    
}