
const parent = [];

function solution(n, costs) {
    
    costs.sort((a,b) => a[2] - b[2])
    
    for(let i=0; i<n; i++){
        parent.push(i)
    }
    
    var answer = 0;
    
    for(let i=0; i<costs.length; i++){
        if(find(costs[i][0]) == find(costs[i][1])) continue;
        answer += costs[i][2]
        union(costs[i][0], costs[i][1])
    }
    
    return answer
}

function union(a, b){
    let pa = parent[a]
    let pb = parent[b]
    if(pa != pb) parent[pb] = pa
}

function find(x){
    if(parent[x] == x) return x
    else return parent[x] = find(parent[x]);
}
