function solution(s) {
    
    const num = ["zero", "one", "two", "three", "four", "five", "six", "seven","eight", "nine"];
    
    for(let i=0; i<num.length; i++){
        s = s.replaceAll(num[i], i);
    }
    
    var answer = Number(s);
    
    return answer;
}