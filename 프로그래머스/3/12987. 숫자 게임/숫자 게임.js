function solution(A, B) {
    
    A.sort((a,b) => a-b)
    B.sort((a,b) => a-b)
    
    var aIndex = 0;
    var answer = 0;
    
    for(let i=0; i<B.length; i++){
        if(B[i] > A[aIndex]){
            aIndex++;
            answer++;
        }
    }   
    
    return answer;
}