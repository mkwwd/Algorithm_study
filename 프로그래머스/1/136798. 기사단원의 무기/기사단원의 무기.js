function solution(number, limit, power) {
    
    var answer = 0;
    
    for(let i=1; i<=number; i++){
        var cnt = div(i);
        if(cnt <= limit){
            answer += cnt;
        }else{
            answer += power;
        }
    }
    
    return answer;
}

function div(num){
    
    if(num == 1) return 1;
    
    var set = new Set();
    
    for(let i=1; i<=Math.sqrt(num); i++){
        if(num%i == 0){
            set.add(i);
            set.add(num/i);
        }
    }
    
    return set.size;
        
}