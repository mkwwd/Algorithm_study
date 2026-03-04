function solution(cookie) {
    
    var answer = 0;
    
    for(let i=0; i<cookie.length-1; i++){
        var left = i;
        var leftSum = cookie[left];
        var right = i+1;
        var rightSum = cookie[right];
        while(true){
            if(leftSum == rightSum && leftSum > answer){
                answer = leftSum;
            }else if(leftSum > rightSum && right < cookie.length-1){
                right++;
                rightSum += cookie[right];
            }else if(leftSum <= rightSum && left > 0){
                left--;
                leftSum += cookie[left];
            }else break;
        }
    }
    
    return answer;
}