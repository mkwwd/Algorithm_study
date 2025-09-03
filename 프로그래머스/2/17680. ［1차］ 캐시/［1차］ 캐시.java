import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) return cities.length *5;
        
        Deque<String> cache = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<cities.length; i++){
            String now = cities[i].toLowerCase();
            if(cache.contains(now)){
                answer += 1;
                cache.remove(now);
            }else{
                if(cache.size() >= cacheSize){
                    cache.pollFirst();
                }
                answer += 5;
            }
            cache.add(now);
        }

        return answer;
    }
}