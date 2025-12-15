function solution(sequence) {
    
    var len = sequence.length;
    
    const arr = Array.from({length : len}, () => Array(2).fill(0));
    
    arr[0][0] = sequence[0];
    arr[0][1] = -sequence[0];
    
    for(let i=1; i<len; i++){
        arr[i][0] = Math.max(arr[i-1][1], 0) + sequence[i];
        arr[i][1] = Math.max(arr[i-1][0], 0) - sequence[i];
    }
    
    var answer = 0;
    
    for(let ar of arr){
        answer = Math.max(answer, Math.max(ar[0], ar[1]));
    }
    
    return answer;
}