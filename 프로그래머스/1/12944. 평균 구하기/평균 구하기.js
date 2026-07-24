function solution(arr) {
    
    var sum = arr.reduce((acc, cur) => acc+cur, 0);
    var len = arr.length;
    
    var answer = sum/len;
    
    return answer;
}