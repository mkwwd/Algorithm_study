import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        HashSet<String> type = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> gemCount = new HashMap<>();
        
        int answer[] = {0, gems.length};
        int left = 0;
        int right = 0;
        int max = type.size();
        
        while(right < gems.length){
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(gemCount.size() == max){
                // 기존 범위보다 작으면 갱신
                if(right - left < answer[1]- answer[0]){
                    answer[0] = left;
                    answer[1] = right;
                }
                // 범위보다 크면은 범위를 줄여보자
                if(gemCount.get(gems[left]) > 1){
                    gemCount.put(gems[left], gemCount.get(gems[left]) -1);
                }else{
                    gemCount.remove(gems[left]);
                }
                left++;
            }
            
        }
        
        answer[0] ++;
        
        return answer;
    }
}