function solution(arr) {
    
    var answer = arr[0];
    
    for(let i=1; i<arr.length; i++){
        answer = lcm(answer, arr[i]);
    }

    return answer;
}

function lcm(a, b){
    return a * b / gcd(a, b);
}

function gcd(a, b){
    if(b == 0) return a;
    return gcd(b, a%b);
}