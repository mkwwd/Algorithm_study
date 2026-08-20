function solution(s) {
    
    const map = new Map();
    var answer = [];
    
    for(let i=0; i<s.length; i++){
        var char = s.charAt(i);
        if(!map.has(char)){
            answer.push(-1);
        }else{
            var index = map.get(char);
            answer.push(i-index);
        }
        map.set(char, i);
    }

    return answer;
}