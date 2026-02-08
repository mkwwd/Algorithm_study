function solution(a) {
    
    var len = a.length;
    
    const frontMin = Array(len).fill(0);
    const backMin = Array(len).fill(0);
    
    frontMin[0] = a[0];
    for(let i=1; i<len; i++){
        frontMin[i] = Math.min(frontMin[i-1], a[i]);
    }
    
    backMin[len-1] = a[len-1];
    for(let i=len-2; i>=0; i--){
        backMin[i] = Math.min(backMin[i+1], a[i])
    }
    
    var answer = 0;
    for(let i=0; i<len; i++){
        if(a[i] == frontMin[i] || a[i] == backMin[i]) answer++;
    }
    
    return answer;
}