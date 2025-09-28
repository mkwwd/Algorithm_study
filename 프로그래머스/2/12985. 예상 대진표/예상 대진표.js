function solution(n,a,b)
{
    var answer = 0;

    while(n > 0){
        
        a = Math.ceil(a/2)
        b = Math.ceil(b/2)
        
        if(a==b) break;
        answer++;
            
    }

    return answer+1;
}