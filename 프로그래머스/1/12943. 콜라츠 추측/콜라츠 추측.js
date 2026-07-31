function solution(num) {
    
    var answer = 0;
    
    while(num !=1 && answer < 500){
        if(num%2 == 0){
            num/=2;
        }else{
            num*=3;
            num++;
        }
        answer++;
    }
    
    if(answer == 500) answer = -1;
    
    return answer;
}