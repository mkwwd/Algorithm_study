var min = 0;
var isUsed;

function solution(begin, target, words) {
    
    var n = words.length;
    isUsed = Array(n).fill(false);
    min = n;
    
    dfs(begin, target, words, 0);
    
    if(min == n) min = 0;

    return min;
}

function dfs(begin, target, words, change){
    
    if(change >= min) return; 
    
    if(begin == target){
        min = Math.min(min, change);
        return;
    }
    
    for(let i=0; i<words.length; i++){
        var now = words[i];
        if(isUsed[i]) continue;
        var cnt = 0;
        for(let j=0; j<now.length; j++){
            if(begin.charAt(j) != now.charAt(j)) cnt++;
        }
        
        if(cnt == 1){
            isUsed[i] = true;
            dfs(now, target, words, change+1);
            isUsed[i] = false;
        }
    }
}