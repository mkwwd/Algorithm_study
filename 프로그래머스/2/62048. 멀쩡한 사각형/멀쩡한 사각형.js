function solution(w, h) {
    
    var dup = gcd(w, h);
    var size = w*h;
    var sum = w+h;
    
    var answer = size - (sum - dup);
    
    return answer;
}

function gcd(w, h){
    if(w%h == 0) return h;
    else return gcd(h, w%h);
}