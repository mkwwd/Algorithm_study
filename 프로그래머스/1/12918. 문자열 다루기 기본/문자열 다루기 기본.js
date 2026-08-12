function solution(s) {
    
    if(s.length !=4 && s.length !=6) return false;
    
    var str = s.toLowerCase();
    
    if(str.includes("x") || str.includes("e") || str.includes("o") || str.includes("b")) return false;
    
    var answer = true;
    var number = Number(str);
    
    
    if(isNaN(number)){
        answer = false;
    }
    
    return answer;
}