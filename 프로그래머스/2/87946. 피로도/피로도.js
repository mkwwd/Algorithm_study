var answer = 0;
var visited;
var N;
const list = [];

function solution(k, dungeons) {
   
    N = dungeons.length;
    visited = Array.from({length : N}).fill(false);
    permutation(dungeons, 0, k)
    
    return answer; 
}

function permutation(dungeons, cnt, K){
    
    if(cnt == N){
        var stress = K;
        var go = 0;
        for(let i=0; i<list.length; i++){
            if(dungeons[list[i]][0] <= stress){
                stress -= dungeons[list[i]][1];
                go++;
            }else break;
        }
        answer = Math.max(answer, go);
        return;
    }
    
    for(let i=0; i<N; i++){
        if(visited[i]) continue;
        visited[i] = true;
        list.push(i);
        permutation(dungeons, cnt+1, K);
        visited[i] = false;
        list.pop();
    }
}