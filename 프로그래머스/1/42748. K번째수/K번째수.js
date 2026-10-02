function solution(array, commands) {
    
    var answer = [];
    
    for(let i=0; i<commands.length; i++){
        let st = commands[i][0]-1;
        let end = commands[i][1];
        let k = commands[i][2];
        const cut = array.slice(st, end);
        cut.sort((a,b) => a-b);
        answer[i] = cut[k-1];
    }
    
    return answer;
}