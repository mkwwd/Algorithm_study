var answer = 0;
var list = [];

function solution(n, q, ans) {
    
    combination(1, n, q, ans);

    return answer;
}

function combination(st, n, q, ans){
    
    if(list.length == 5){
        if(isValid(q, ans)) answer++;
        return;
    }
    
    for(let i=st; i<=n; i++){
        list.push(i);
        combination(i+1, n, q, ans);
        list.pop();
    }
    
}

function isValid(q, ans){
    
    for(let i=0; i<q.length; i++){
        var cnt = 0;
        for(let j=0; j<5; j++){
            if(list.includes(q[i][j])) cnt++;
        }
        if(cnt != ans[i]) return false;
    }
    
    return true;
        
}
