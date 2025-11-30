function solution(diffs, times, limit) {
    
    var min = 1;
    var max = 300000;
    
    while(min <= max){
        var mid = Math.floor((min + max)/2);
        if(isSolved(diffs, times, mid, limit)){
            max = mid - 1;
        }else{
            min = mid + 1;
        }
    }

    return min;
}

function isSolved(diffs, times, mid, limit){
    
    var sum = 0;
    
    for(let i=0; i<diffs.length; i++){
        if(diffs[i] <= mid){
            sum += times[i];
        }else{
            sum += (times[i-1] + times[i])*(diffs[i] - mid) + times[i];
        }
    }
    
    if(sum <= limit) return true;
    return false;
    
}