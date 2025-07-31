function solution(A,B){
    
    A.sort((a,b) => a-b);
    B.sort((a,b) => a-b);
    
    var answer = 0;
    
    for(let i=0; i<A.length; i++){
        answer += A[i]*B[A.length-1-i];
    }

    return answer;
}