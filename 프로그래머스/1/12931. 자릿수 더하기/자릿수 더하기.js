function solution(n)
{
    var answer = 0;

    while(n > 0){
        var mod = n%10;
        answer += mod;
        n = Math.floor(n/10);
    }

    return answer;
}