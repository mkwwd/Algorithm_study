function solution(n, lost, reserve) {
    
    var lostSet = new Set();
    var reserveSet = new Set();
    
    lost.sort((a,b) => a-b);
    
    for(let i=0; i<lost.length; i++){
        lostSet.add(lost[i]);
    }
    
    for(let i=0; i<reserve.length; i++){
        if(lostSet.has(reserve[i])){
            lostSet.delete(reserve[i]);
            continue;
        }
        reserveSet.add(reserve[i]);
    }
    
    var possible = n-lostSet.size;
    
    for(let item of lostSet){
        if(reserveSet.has(item-1)){
            possible++;
            reserveSet.delete(item-1);
        }else if(reserveSet.has(item+1)){
            possible++;
            reserveSet.delete(item+1);
        }
    }
    
    return possible;
}