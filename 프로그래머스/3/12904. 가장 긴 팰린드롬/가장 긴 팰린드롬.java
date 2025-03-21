import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int len = s.length();
        int palindrome[][] = new int[len][len];
        int answer = 1;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<i+1; j++){
                if(i == j){
                    palindrome[j][i] = 1;
                }else{
                    if(s.charAt(j) != s.charAt(i)) continue;
                    if(j+1 <= i-1) {
                        if(palindrome[j+1][i-1] == 0) continue;
                    }
                    palindrome[j][i] = 1;
                    answer = Math.max(answer, i-j+1);
                }
            }
        }

        return answer;
    }
}