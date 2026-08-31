function solution(s) {
    
    var answer = '';
    var idx = 0;
    
    for(let i=0; i<s.length; i++){
        if(idx % 2 == 0){
            answer = answer+ s.charAt(i).toUpperCase();
        }else{
            answer = answer + s.charAt(i).toLowerCase();
        }
        idx++;
        if(s.charAt(i) == ' ') idx = 0;
    }
    
    return answer;
}