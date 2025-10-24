function solution(priorities, location) {
    
    const que = [];
    const pq = [];
    
    for(let i=0; i<priorities.length; i++){
        var num = priorities[i];
        que.push([num, i]);
        pq.push(num);
    }
    
    pq.sort((a,b) => b-a);
    
    var answer = 0;
    var cnt = 0;
    
    while(que.length){
        let now = que.shift();
        if(now[0] == pq[0]){
            pq.shift();
            cnt++;
            if(now[1] == location){
                answer = cnt;
                break;
            }
        }else{
            que.push(now);
        }
    }
    
    return answer;
}