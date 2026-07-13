function solution(phone_number) {
    
    var len = phone_number.length;
    var cut = phone_number.substring(len-4);
    var answer ="*".repeat(len-4);
    
    answer = answer + cut;
    
    return answer;
}