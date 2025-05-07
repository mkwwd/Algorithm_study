function solution(s){
    
    const arr = [];
    
    for(let i=0; i<s.length; i++){
        if(arr.length >= 1){
            if(arr[arr.length -1] === '(' && s[i] === ')'){
                arr.pop();
                continue;
            }
        }
        
        arr.push(s[i]);
    }
    
    var answer = true;
    
    if(arr.length != 0) answer = false;

    return answer;
}