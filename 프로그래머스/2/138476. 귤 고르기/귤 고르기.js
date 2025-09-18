function solution(k, tangerine) {
    
    const map = new Map();
    
    for(let i=0; i<tangerine.length; i++){
        map.set(tangerine[i], (map.get(tangerine[i]) || 0) + 1);
    }
    
    const tangArr  = [];
    
    map.forEach((value, key) => {
        tangArr.push([key, value]);
    }) 
    
    tangArr.sort((a, b) => {
        return b[1] - a[1]
    })
    
    var answer = 0;
    var cnt = 0;
    
    while(cnt < k){
        cnt += tangArr[0][1];
        answer ++;
        tangArr.shift();
    }
    
    return answer;
}