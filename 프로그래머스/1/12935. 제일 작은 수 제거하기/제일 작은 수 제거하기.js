function solution(arr) {
    
    if(arr.length == 1) return [-1];
    
    var min = arr[0];
    
    for(let i=1; i<arr.length; i++){
        min = Math.min(min, arr[i]);
    }
    
    var answer = [];
    
    for(let i=0; i<arr.length; i++){
        if(arr[i] == min) continue;
        answer.push(arr[i]);
    }
    
    return answer;
}