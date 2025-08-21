function solution(brown, yellow) {
    var answer = [];
    
    for(let i=0; i<=Math.sqrt(yellow); i++){
        if(yellow%i != 0) continue;
        let width = yellow/i+2;
        let height = i+2;
        if(width*height-yellow == brown){
            answer.push(width);
            answer.push(height);
            break;
        }
    }
    
    return answer;
}