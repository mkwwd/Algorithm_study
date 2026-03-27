
const parent = [];

function solution(n, costs) {
    
    costs.sort((a, b) => a[2]-b[2]);
    
    for(let i=0; i<n+1; i++){
        parent.push(i);
    }
    
    var answer = 0;
    
    for(let i=0; i<costs.length; i++){
        var from = costs[i][0];
        var to = costs[i][1];
        if(find(from) == find(to)) continue;
        answer += costs[i][2];
        union(from, to);
    }
    
    return answer;
}

function find(node){
    if(parent[node] == node) return node;
    return parent[node] = find(parent[node]);
}

function union(a , b){
    let pa = parent[a];
    let pb = parent[b];
    if(pa != pb) parent[pb] = pa;
}
