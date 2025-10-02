function solution(arr) {
    
    var i = 2;
    arr.sort((a, b) => a - b);
    var max = arr[arr.length-1];
    var answer = 1;
    
    while(i <= max){
        
        var cnt = 0;
        var len = arr.length;
        
        for(let j=0; j<len; j++){
            if(arr[j] == 1) continue;
            if(arr[j]%i == 0){
                cnt++;
                arr[j] /= i; 
            }
        }
        
        if(cnt == 0) i++
        else answer *= i
    }

    return answer;
}