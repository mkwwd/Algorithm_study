function solution(scores) {
    
    let a = scores[0][0];
    let b = scores[0][1];
    let sum = a+b;
    
    scores.sort((a, b) => (b[0]+b[1]) -(a[0]+a[1]))
    
    var answer = 0;
    
    for(let i=0; i<scores.length; i++){
        var possible = true;
        for(let j=i-1; j>=0; j--){
            if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]){
                possible = false;
                console.log("Dd")
                break;
            }
        }
        
        if(possible && scores[i][0] + scores[i][1] > sum) answer++;
        
        if(scores[i][0] == a && scores[i][1] == b){
            if(possible) answer++
            else answer = -1
            break;
        }
        
    }
    
    return answer;
}