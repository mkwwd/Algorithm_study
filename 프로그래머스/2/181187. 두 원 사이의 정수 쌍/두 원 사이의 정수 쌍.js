function solution(r1, r2) {
    
    var answer = 0;
    
    for(let i=1; i<=r2; i++){
        var max = Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)))
        var min = Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i, 2))) || 0
        var cnt = max - min + 1;
        answer += cnt*4;
    }
    
    //answer += 4;
   
    return answer;
}