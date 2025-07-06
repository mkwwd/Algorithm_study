function solution(s) {
    
    s = s.substring(2, s.length-2);
    s = s.replace(/},{/g, "-");
    
    const tuple = s.split("-");
    
    tuple.sort((a,b) => a.length - b.length);
    
    var answer = [];
    
    for(let i=0; i<tuple.length; i++){
        let now = tuple[i].split(",");
        for(let j=0; j<now.length; j++){
            let num = Number(now[j])
            if(!answer.includes(num)){
                answer.push(num)
            }
        }
    }
   
    return answer;
}