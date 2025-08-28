const way = {};
const list = ["ICN"];
var find = false;
var num;

function solution(tickets) {  
    
    num = tickets.length;
    
    for(const [from, to] of tickets){
        if(!way[from]) way[from] = [];
        way[from].push(to);
    }
    
    for(const key in way){
        way[key].sort();
    }
    
    dfs("ICN", list);
    
    return list;
}

function dfs(now, list){
    
    if(list.length == num+1){
        find = true;
        return
    }
    
    if(!way[now]) return;
    
    for(let i=0; i<way[now].length; i++){
        if(way[now][i] == null) continue;
        var next = way[now][i];
        way[now][i] = null;
        list.push(next);
        dfs(next, list);
        if(find) return;
        list.pop();
        way[now][i] = next;
    }
    
}