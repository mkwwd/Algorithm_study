function solution(picks, minerals) {
    
    var size = picks[0] + picks[1] + picks[2];
    var min = Math.min(size*5, minerals.length);
    const que = [];
    
    for(let i=0; i<min; i+=5){
        var tired = [0, 0, 0, 0];
        for(let j=0; j<5; j++){
            if(i+j == min) break;
            if(minerals[i+j] == "diamond"){
                tired[0] += 1;
                tired[3] += 25;
            }else if(minerals[i+j] == "iron"){
                tired[1] += 1;
                tired[3] += 5;
            }else{
                tired[2] += 1;
                tired[3] += 1;
            }
        }
        
        que.push(tired);
    }
    
    que.sort((a,b) => a[3] - b[3]);
    
    var answer = 0;
    
    while(que.length){
        var now = que.pop();
        if(picks[0] != 0){
            answer += now[0] + now[1] + now[2];
            picks[0] --;
        }else if(picks[1] != 0){
            answer += now[0]*5 + now[1] + now[2];
            picks[1] --;
        }else{
            answer += now[0]*25 + now[1]*5 + now[2];
            picks[2] --;
        }
    }
    
    return answer;
}