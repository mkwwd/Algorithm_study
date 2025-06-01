var visited = [];

function solution(n, computers) {
   
    var answer = 0;
    visited = new Array(n).fill(false)
    
    for(let i=0; i<computers.length; i++){
        if(visited[i]) continue
        answer++
        dfs(i, computers)
    }
    
    return answer;
}

function dfs(st, computers){
    
    for(let i=0; i<computers.length; i++){
        if(computers[st][i] == 1 && !visited[i]){
            visited[i] = true
            dfs(i, computers)
        }
    }
}
    