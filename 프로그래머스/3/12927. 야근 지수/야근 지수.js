function solution(n, works) {
    
    if(works.reduce((a, b) => a+b) <= n) return 0;
    
    var sortWork = works.sort((a,b) => a-b)
    
    while(n > 0 && works.length > 0){
        
        var max = sortWork[works.length-1];
        
        for(let i=works.length-1; i>=0; i--){
            if(sortWork[i] >= max){
                sortWork[i]--;
                n--;
            }
            if(n==0) break;
        }
        
    }
    
    var answer = 0;
    
    while(works.length){
        var now = works.pop();
        answer += now*now;
    }
    
    return answer;
}