function solution(citations) {
    
    citations.sort((a, b) => a-b);
    var max = citations[citations.length-1];
    var cnt = 0;
    
    for(let i=citations.length-1; ;){
        if(cnt >= max) break;
        if(citations[i] >= max){
            cnt++;
            i--;
            continue;
        }
        max--;
    }
    
    return max;
}