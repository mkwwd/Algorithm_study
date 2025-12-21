import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        HashMap<String, Integer> dic = new HashMap<>();
        
        for(int i=0; i<26; i++){
            dic.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        int len = msg.length();
        int index = 27;
        
        Deque<Integer> compress = new ArrayDeque<>();
        
        for(int i=0; i<len;){
            int plus = 1;
            
            while(i+plus <= len && dic.containsKey(msg.substring(i, i+plus))){
                plus++;
            }
            
            String find = msg.substring(i, i+plus-1);
            compress.add(dic.get(find));
            
            if(i+plus-1 < len){
                dic.put(find + msg.charAt(i+plus-1), index);
                index++;
            }
            
            i += plus-1;
        }
        
        int[] answer = new int[compress.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = compress.poll();
        }
        
        
        return answer;
    }
}