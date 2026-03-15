function solution(n, stations, w) {
   
    var answer = 0;
    var st = 1;
    var range = w*2+1;
    
    for(let i=0; i<stations.length; i++){
        var leftRange = stations[i] - w - 1;
        var len = leftRange - st + 1;
        answer += Math.ceil(len/range);
        st = stations[i] + w + 1;
    }
    
    if(st < n){
        answer += Math.ceil((n-st)/range);
    }else if(st == n){
        answer += 1
    }
    
    return answer;
}