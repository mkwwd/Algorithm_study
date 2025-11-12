import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int N = s.length();
        int palindrome[][] = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(s.charAt(i) != s.charAt(j)) continue;
                if(Math.abs(i - j) > 1 && palindrome[i-1][j+1] != 1) continue;
                palindrome[i][j] = 1;
                answer = Math.max(answer, i-j+1);
            }
        }
        
        return answer;
    }
}