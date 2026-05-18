function solution(n, m) {
    
    var gcbNum = gcb(n, m);
    var lcmNum = n*m/gcbNum;
    
    var answer = [gcbNum, lcmNum];
    
    return answer;
}

function gcb(a , b){
    if(a%b == 0) return b;
    else return gcb(b, a%b);
}