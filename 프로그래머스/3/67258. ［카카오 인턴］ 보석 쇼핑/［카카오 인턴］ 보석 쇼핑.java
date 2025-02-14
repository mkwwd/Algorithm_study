import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int[] answer = {0, gems.length};
        HashSet<String> gem = new HashSet<>(Arrays.asList(gems));
        int max = gem.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        
        while(right < gems.length){
            
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(map.size() == max){
                // 기존 구간보다 짧으면 갱신
                if(right - left < answer[1] - answer[0]){
                    answer[0] = left;
                    answer[1] = right;
                }
                
                map.put(gems[left], map.get(gems[left])-1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
            }
    
        }
        
        answer[0] += 1;
        
        return answer;
    }
}