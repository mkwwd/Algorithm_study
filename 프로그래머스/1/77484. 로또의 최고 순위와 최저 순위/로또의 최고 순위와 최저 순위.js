function solution(lottos, win_nums) {
    
    const rank = [6, 6, 5, 4, 3, 2, 1];
    
    const set = new Set();
    
    for(let i=0; i<win_nums.length; i++){
        set.add(win_nums[i]);
    }
    
    var cnt = 0;
    var zero = 0;
    
    for(let i=0; i<lottos.length; i++){
        if(set.has(lottos[i])) cnt++;
        if(lottos[i] == 0) zero++;
    }
    
    var answer = [rank[cnt+zero], rank[cnt]];
    
    return answer;
}