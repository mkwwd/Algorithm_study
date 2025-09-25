function solution(n, words) {
    
    const used = new Map();
    var cnt = 0;
    var before = "";
    
    for(let i=0; i<words.length; i++){
        if(used.has(words[i])) break;
        if(before.length == 0 || before.charAt(before.length-1) == words[i].charAt(0)){
            before = words[i]
            cnt++
            used.set(words[i])
        }else break;
    }
    
    if(cnt == words.length) return [0,0]
    
    cnt++
    
    var num = cnt%n
    if(num == 0) num = n;
    
    var turn = Math.ceil(cnt/n)

    return [num ,turn];
}