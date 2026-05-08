import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int size = (int)(end - begin + 1);
        int answer[] = new int[size];
        
        for(int i=0; i<size; i++){
            answer[i] = find((int)(i + begin));
        }
        
        return answer;
    }
    
    public int find(int num){
        if(num == 1) return 0;
        int max = 1;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                max = i;
                int ans = num/max;
                if(ans <= 10000000) return ans;
            }
        }
        
        return max;
    }
    
}