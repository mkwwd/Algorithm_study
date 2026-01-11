function solution(n, l, r) {
    var answer = 0;
    for(let i=l-1; i<r; i++){
        var isOne = true;
        var num = i;
        while(num >= 5){
            if(num%5 == 2){
                isOne = false;
                break;
            }
            num = Math.floor(num/5);
        }
        if(num == 2) isOne = false;
        if(isOne) answer++;
    }
    return answer;
}