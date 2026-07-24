function solution(x) {
    
    var str = x.toString();
    var arr = str.split("");
    
    var sum = arr.reduce((acc, cur) => acc + Number(cur), 0);

    var answer = false;
    if(x%sum == 0) answer = true;
    
    return answer;
}