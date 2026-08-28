function solution(t, p) {
    
    var len = p.length;
    var answer = 0;
    
    for(let i=0; i<t.length-len+1; i++){
        var str = t.substring(i, i+len);
        if(Number(str) <= Number(p)) answer++;
    }
    
    return answer;
}