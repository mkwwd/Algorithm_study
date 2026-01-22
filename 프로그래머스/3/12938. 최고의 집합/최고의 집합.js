function solution(n, s) {
    
    var div = Math.floor(s/n);
    var mod = s%n;
    
    if(div == 0) return [-1];
    
    var answer = Array(n).fill(0);
    
    for(let i=n-1; i>=0; i--){
        if(mod > 0){
            answer[i] = div+1;
            mod--;
        }else{
            answer[i] = div;
        }
    }
    
    return answer;
}