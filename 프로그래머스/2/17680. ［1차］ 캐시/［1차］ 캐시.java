import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) return 5 * cities.length;
        
        Deque<String> que = new ArrayDeque<>();
        
        int answer = 0;
        
        for(int i=0; i<cities.length; i++){
            String str = cities[i].toLowerCase();
            if(que.contains(str)){
                answer +=1;
                que.remove(str);
                que.add(str);
            }else{
                answer += 5;
                if(que.size() >= cacheSize){
                    que.removeFirst();
                }
                que.add(str);
            }
        }
        

        return answer;
    }
}