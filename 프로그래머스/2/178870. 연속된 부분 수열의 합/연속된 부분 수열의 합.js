function solution(sequence, k) {
    var answer = [0, 0];
    
    var left = 0;
    var right = 0;
    var sum = sequence[0];
    var len = Number.MAX_SAFE_INTEGER;
    
    while(right < sequence.length){
        if(sum < k){
            right++
            if(right < sequence.length) sum += sequence[right];
        }else{
            if(sum == k){
                if(right - left < len){
                    len = right-left
                    answer[0] = left
                    answer[1] = right
                }
            }
            sum -= sequence[left];
            left++;
        }
    }
    
    return answer;
}