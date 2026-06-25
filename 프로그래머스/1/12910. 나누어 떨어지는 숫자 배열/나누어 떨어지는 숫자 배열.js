function solution(arr, divisor) {
    
    arr.sort((a,b) => a-b);
    
    var answer = [];
    
    for(let i=0; i<arr.length; i++){
        if(arr[i]%divisor == 0){
            answer.push(arr[i]);
        } 
    }
    
    if(!answer.length) return [-1];
    
    return answer;
}