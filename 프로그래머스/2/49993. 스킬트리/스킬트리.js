function solution(skill, skill_trees) {
    
    const turn = [];
    
    for(let i=0; i<skill.length; i++){
        turn.push(skill[i]);
    }
    
    var answer = 0;

    for(let i=0; i<skill_trees.length; i++){
        var index = 0;
        var now = skill_trees[i];
        var possible = true;
        for(let j=0; j<now.length; j++){
            if(turn.indexOf(now.charAt(j)) >= 0){
                if(turn[index] == now.charAt(j)){
                    index++;
                }else{
                    possible = false;
                    break;
                }
            }
        }
        if(possible) answer++
    }
    
    return answer;
}