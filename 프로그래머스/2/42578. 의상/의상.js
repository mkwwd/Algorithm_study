function solution(clothes) {
    
    var type = new Map();
    
    for(let i=0; i<clothes.length; i++){
        if(type.has(clothes[i][1])){
            type.set(clothes[i][1], type.get(clothes[i][1])+1);
        }else{
            type.set(clothes[i][1], 1);
        }
    }
    
    var answer = 1;
    
    type.forEach((value, key) => {
        answer *= (value+1);
    })
    
    return answer-1;
}