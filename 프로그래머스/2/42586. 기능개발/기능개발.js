function solution(progresses, speeds) {
    
    const work = [];
    const finish = [];
    
    for(let i=0; i<progresses.length; i++){
        work.push([progresses[i], speeds[i]]);
    }
    
    var index = 1;
    
    while(work.length){
        var cnt = 0;
        var size = work.length;
        for(let i=0; i<size; i++){
            if(work[0][0] + work[0][1]*index >= 100){
                work.shift();
                cnt++;
            }else break;
        }
        if(cnt > 0){
            finish.push(cnt);
        }
        index++;
    }
    
    return finish;
}