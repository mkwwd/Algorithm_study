function solution(n) {
    
    var left = 1;
    var right = 1;
    var sum = 1;
    var answer = 0;
    
    while(left <= right){
        if(sum <= n){
            if(sum == n) answer ++;
            right++;
            sum += right
        }else{
            sum -= left;
            left++;
        }
    }
    
    return answer;
}