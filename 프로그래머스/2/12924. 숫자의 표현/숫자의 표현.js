function solution(n) {
    
    if(n<=2) return 1;
    
    var left = 1;
    var right = 2;
    var sum = left + right;
    var answer = 0;
    
    while(left <= right){
        
        if(sum <= n){
            if(sum == n) answer ++;
            right++;
            sum += right;
        }else{
            sum -= left;
            left++
        }
    }
    
    return answer;
}