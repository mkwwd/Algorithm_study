function solution(n, stations, w) {
    var answer = 0;

    var st = 0;
    var end = 0;
    var range = w*2 + 1;
    
    for(let i=0; i<stations.length; i++){
        end = stations[i] -1 - w;
        answer += Math.ceil((end-st)/range);
        st = stations[i] + w;
    }
    
    if(st < n){
        answer += Math.ceil((n-st)/range);
    }

    return answer;
}