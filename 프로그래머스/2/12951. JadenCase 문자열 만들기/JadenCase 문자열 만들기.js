function solution(s) {
    
    var answer = '';
    var first = true;
    
    for(let i=0; i<s.length; i++){
        if(s.charAt(i) == " "){
            first = true;
            answer += " ";
        }else{
            if(first){
                answer += s.charAt(i).toUpperCase();
                first = false;
            }else{
                answer += s.charAt(i).toLowerCase();
            }
        }
    }
    
    return answer;
}