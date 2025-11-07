function solution(stones, k) {
    
    var min = 0;
    var max = 200000000;
    
    while(min <= max){
        
        var mid = Math.floor((min+max)/2);
        
        if(checkStone(mid, k, stones)){
            min = mid + 1;
        }else{
            max = mid - 1;
        }
        
    }
    
    return max;
}

function checkStone(mid, k, stones){
    var cnt = 0;
    
    for(let i=0; i<stones.length; i++){
        if(stones[i] - mid < 0){
            cnt++;
        }else cnt = 0;
        
        if(cnt >= k) return false;
    }
    
    return true;
    
}
