function solution(cards) {
    
    const set = new Set();
    const que = [];
    
    for(let card of cards){
        
        var now = card;
        var len = 0;
        
        while(!set.has(now)){
            set.add(now);
            len++;
            now = cards[now-1];
        }
        
        que.push(len);
        
    }
    
    que.sort((a,b) => b-a);

    return que[0]*que[1];
}