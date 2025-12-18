function solution(targets) {
    
    targets.sort((a,b) => {
        if(a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
    })
    
    var answer = 0;
    var end = 0 ; 
    
    for(let i=0; i<targets.length; i++){
        if(targets[i][0] >= end){
            answer ++;
            end = targets[i][1];
        }
    }
    
    
    return answer;
}