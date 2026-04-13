function solution(distance, rocks, n) {
    
    rocks.push(distance);
    rocks.sort((a, b) => a-b);
    
    var left = 1;
    var right = distance;
    var answer = 0;
    
    while(left <= right){
        
        var st = 0;
        var dis = 0;
        var mid = Math.floor((left+right)/2);
        var cnt = 0;
        
        for(let i=0; i<rocks.length; i++){
            dis += rocks[i]-st;
            if(dis < mid){
                cnt++;
            }else{
                dis = 0;
            }
            st = rocks[i];
        }
        
        if(cnt <= n){
            answer = mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
        
    }
    
    return answer;
}