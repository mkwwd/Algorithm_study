function solution(jobs) {
    
    jobs.sort((a,b) => a[0] - b[0]);
    
    var que = [];
    var time = 0;
    var index = 0;
    var answer = 0;
    var finish = 0;
    
    while(finish < jobs.length){
        
        while(index < jobs.length && time >= jobs[index][0]){
            que.push(jobs[index++]);
        }
        
        que.sort((a,b) => b[1] - a[1]);
        
        if(!que.length){
            time = jobs[index][0];
        }else{
            var out = que.pop();
            time += out[1];
            answer += time - out[0];
            finish++;
        }
        
    }
    
    return Math.floor(answer/jobs.length);
}