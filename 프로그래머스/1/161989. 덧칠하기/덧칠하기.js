function solution(n, m, section) {
    
    var answer = 0;
    var now = 0;
    
    for(let i=0; i<section.length; i++){
        if(now >= section[i]) continue;
        now = section[i]+m-1;
        answer++;
    }
    
    return answer;
}