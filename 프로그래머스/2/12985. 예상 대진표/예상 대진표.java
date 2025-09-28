import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(n > 0){
            
            a = (int)Math.ceil((double)a/2);
            b = (int)Math.ceil((double)b/2);
            
            if(a == b) break;
            
            n /= 2;
            answer++;
                
        }

        return answer+1;
    }
}