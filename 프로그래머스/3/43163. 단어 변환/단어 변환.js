var min = 0;

function solution(begin, target, words) {
    
    min = words.length;
    const use = new Array(words.length).fill(false)
    
    dfs(begin, target, words, use, 0)
    
    if(min == words.length) min = 0

    return min;
}

function dfs(begin, target, words, use, sum){
    
    if(sum > min) return;
    
    if(begin == target) {
        min = Math.min(min, sum)
        return
    }
    
    for(let i=0; i<words.length; i++){
        if(use[i]) continue;
        var cnt = 0;
        for(let j=0; j<begin.length; j++){
            if(begin.charAt(j) != words[i].charAt(j)) cnt++
        }
        if(cnt == 1){
            use[i] = true; 
            dfs(words[i], target, words, use, sum+1);
            use[i] = false;
        }
    }
    
}