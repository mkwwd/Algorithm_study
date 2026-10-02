function solution(participant, completion) {
    
    var goal = new Map();
    
    for(let i=0; i<completion.length; i++){
        if(goal.has(completion[i])){
            goal.set(completion[i], goal.get(completion[i]) + 1);
        }else{
            goal.set(completion[i], 1);
        }
    }
    
    var answer = '';
    
    for(let i=0; i<participant.length; i++){
        let cnt = goal.get(participant[i]);
        if(cnt == 0 || cnt == undefined){
            answer = participant[i];
            break;
        }else{
            goal.set(participant[i], cnt-1);
        }
    }
    
    return answer;
}