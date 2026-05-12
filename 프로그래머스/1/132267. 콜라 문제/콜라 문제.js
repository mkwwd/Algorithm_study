function solution(a, b, n) {
    
    var answer = 0;
    
    while(a <= n){
        let trade = Math.floor(n/a)*b;
        let left = n%a;
        answer += trade;
        n = trade + left;
    }
    
    return answer;
}