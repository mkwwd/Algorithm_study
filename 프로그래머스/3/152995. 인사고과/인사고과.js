function solution(scores) {
    
    let a = scores[0][0];
    let b = scores[0][1];
    
    scores.sort((a,b) => (b[0]+b[1])-(a[0]+a[1]));
    
    let answer = 0;
    
    for(let i=0; i<scores.length; i++){
        if(scores[i][0] + scores[i][1] < a + b) break;
        let isPoss = true;
        for(let j=0; j<i; j++){
            if(scores[j][0] > scores[i][0] && scores[j][1] > scores[i][1]){
                isPoss = false;
                break;
            }
        }
        
        if(isPoss && scores[i][0] + scores[i][1] > a + b){
            answer++;
        }else if(scores[i][0] == a && scores[i][1] == b){
            if(!isPoss) answer = -1;
            else answer++;
            break;
        }
    }
   
    
    return answer;
}