function solution(n, cores) {
    
    if (n <= cores.length) return n;
    
    var min = 1;
    var max = 10000*n;
    var cnt = 0;
    
    while(min <= max){
        var mid = Math.floor((min + max)/2);
        cnt = cores.length;
        for(let i=0; i<cores.length; i++){
            cnt += Math.floor(mid/cores[i]);
        }
        if(cnt >= n){
            max = mid - 1;
        }else{
            min = mid + 1;
        }
    }
    
    cnt = cores.length;
    
    for(let i=0; i<cores.length; i++){
        cnt += Math.floor((min - 1)/cores[i]);
    }
    
    var answer = 0;
    
    for(let i=0; i<cores.length; i++){
        if(min % cores[i] == 0){
            cnt++;
            if(cnt == n){
                answer = i+1;
                break;
            }
        }
    }    
    
    return answer;
}