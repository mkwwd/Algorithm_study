function solution(n, left, right) {
    
    const range = right-left+1;
    var answer = Array.from({length : range}).fill(0);
    var cnt = 0;
    var index = 0;
    
    for(let i=1; i<=n; i++){
        if(i*n-1 < left){
            cnt += n;
            continue;
        }
        for(let j=1; j<=n; j++){
            if(cnt < left){
                cnt++;
                continue;
            }
            if(left <= cnt && cnt <= right){
                cnt++;
                answer[index++] = Math.max(i, j);
                continue;
            }
            break;
        }
        if(cnt > right) break;
    }
    
    return answer;
}