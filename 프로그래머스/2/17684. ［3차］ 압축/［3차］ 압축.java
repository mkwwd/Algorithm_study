import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        HashMap<String, Integer> dic = new HashMap<>();

        for(int i=0; i<26; i++){
            dic.put(String.valueOf((char)('A'+i)),i+1);
        }
        
        int index = 27;
        Deque<Integer> press = new ArrayDeque<>();
        
        for(int i=0; i<msg.length(); ){
            int len = 1;
            
            while(i+len <= msg.length() && dic.containsKey(msg.substring(i, i+len))){
                len++;
            }
            
            // 일치하는 부분을 찾았으면 que에 넣기
            String find = msg.substring(i, i+len-1);
            press.add(dic.get(find));
            
            // 새로운 단어 업데이트
            if(i+len-1 < msg.length()){
                dic.put(find+msg.charAt(i+len-1), index);
                index++;
            }
            
            i += len-1;           
        }
        
        int size = press.size();
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            answer[i] = press.poll();
        }
        
        return answer;
    }
}