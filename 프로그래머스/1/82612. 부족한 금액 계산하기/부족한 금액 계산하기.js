function solution(price, money, count) {
    
    var answer = 0;
    
    while(count > 0){
        answer += price*count;
        count--;
    }
    
    if(money > answer) return 0;

    return answer-money;
}