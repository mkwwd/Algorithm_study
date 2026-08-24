function solution(n) {
    
    var three = n.toString(3);
    
    var reverse = three.split('').reverse().join('');
   
    var answer = parseInt(reverse, 3);
    
    return answer;
}