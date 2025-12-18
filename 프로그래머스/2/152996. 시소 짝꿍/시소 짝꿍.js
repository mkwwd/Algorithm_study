function solution(weights) {
    var answer = 0;
    
    const map = new Map();
    
    weights.sort((a,b) => a - b);
    
    for(let w of weights){
        var a = w*1.0;
        var b = w*2.0/3.0;
        var c = w*1.0/2.0;
        var d = w*3.0/4.0;
        
        if(map.has(a)) answer += map.get(a);
        if(map.has(b)) answer += map.get(b);
        if(map.has(c)) answer += map.get(c);
        if(map.has(d)) answer += map.get(d);
        
        map.set(w*1.0, (map.get(w*1.0) ?? 0) + 1);
    }
    
    return answer;
}