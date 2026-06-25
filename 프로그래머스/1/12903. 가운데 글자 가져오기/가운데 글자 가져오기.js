function solution(s) {
    
    var num = Math.floor(s.length/2);
    
    var answer = '';
    
    if(s.length%2 == 0){
        answer = s.substring(num-1, num+1);
    }else{
        answer = s.substring(num, num+1);
    }
    
    return answer;
}