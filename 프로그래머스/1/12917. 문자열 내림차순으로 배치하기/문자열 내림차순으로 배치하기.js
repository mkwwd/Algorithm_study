function solution(s) {
    
    var arr = s.split('');
    
    arr.sort();
    
    var answer = arr.reverse().join('');
    
    return answer;
}