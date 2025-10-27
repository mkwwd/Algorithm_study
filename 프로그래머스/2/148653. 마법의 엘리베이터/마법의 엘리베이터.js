function solution(storey) {
    
    var answer = 0;
    
    while(storey != 0){
        var left = storey % 10;
        storey = Math.floor(storey/10);
        if(left > 5){
            storey ++;
            answer += 10 - left;
        }else if(left < 5){
            answer += left;
        }else{
            if(storey % 10 >= 5){
                storey++;
            }
            answer += left;
        }
    }
    
    return answer;
}