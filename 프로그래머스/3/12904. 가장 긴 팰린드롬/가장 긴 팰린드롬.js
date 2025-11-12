function solution(s)
{
    var answer = 1;
    var N = s.length;
    const palindrome = Array.from({length : N}, () => Array(N).fill(0));
    
    for(let i=0; i<N; i++){
        for(let j=0; j<i+1; j++){
            if(s.charAt(i) != s.charAt(j)) continue;
            if(i-j > 1 && palindrome[i-1][j+1] != 1) continue;
            palindrome[i][j] = 1;
            answer = Math.max(answer, i-j+1);
        }
    }

    return answer;
}