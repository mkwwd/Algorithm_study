import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end-begin+1);
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            long num = begin + i;
            answer[i] = find(num);
        }
        
        return answer;
    }
    
    public int find(long now){
        
        if(now == 1) return 0;
        int max = 1;
        for(long i = 2; i<=Math.sqrt(now); i++){
            if(now%i == 0){
                max = (int)i;
                long ans = now/i;
                if(ans <= 10000000) return (int)ans;
            }
        }
        return max;
    }
}