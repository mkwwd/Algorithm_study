function solution(name) {
    
    var answer = 0;
    var len = name.length;
    var move = len - 1;
    
    for(let i=0; i<len; i++){
        var now = name.charAt(i);
        answer += Math.min(now.charCodeAt(0)-'A'.charCodeAt(0), 'Z'.charCodeAt(0)-now.charCodeAt(0) + 1);
    
        var next = i + 1;
        
        while(next < len && name.charAt(next) == 'A'){
            next++;
        };
        
        move = Math.min(move, i*2 + len - next);
        move = Math.min(move, (len-next)*2 + i);
    }
    
    return answer + move;
}