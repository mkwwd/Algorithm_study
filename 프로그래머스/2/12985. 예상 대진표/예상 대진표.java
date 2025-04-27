import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int answer = 1;
        
        while(n > 1){
            
            int aZone = (int)Math.ceil((double)a/2);
            int bZone = (int)Math.ceil((double)b/2);
            
            if(aZone == bZone){
                break;
            }else{
                a = aZone;
                b = bZone;
                answer ++;
            }
        
            
        }
        

        return answer;
    }
}