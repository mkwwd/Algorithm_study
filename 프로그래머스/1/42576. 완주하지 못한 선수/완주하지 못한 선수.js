function solution(participant, completion) {
    
    var map = new Map();
    
    for(let i=0; i<completion.length; i++){
        if(map.has(completion[i])){
            map.set(completion[i], map.get(completion[i]) + 1);
        }else{
            map.set(completion[i], 1);
        }
    }
    
    var answer = '';
    
    for(let i=0; i<participant.length; i++){
        if(map.has(participant[i])){
            if(map.get(participant[i]) == 1){
                map.delete(participant[i]);
            }else{
                map.set(participant[i], map.get(participant[i]) - 1);
            }
        }else{
            answer = participant[i];
            break;
        }
    }
    
    return answer;
}