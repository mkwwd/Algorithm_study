import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<win_nums.length; i++){
            set.add(win_nums[i]);
        }
        
        int cnt = 0;
        int zero = 0;
        
        for(int i=0; i<lottos.length; i++){
            if(set.contains(lottos[i])) cnt++;
            if(lottos[i] == 0) zero++;
        }
        
        int[] answer = {rank[cnt+zero], rank[cnt]};
        
        return answer;
    }
}