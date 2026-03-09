import java.util.*;

class Solution {
    
    static HashMap<Long, Long> room = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        
        for(int i=0; i<room_number.length; i++){
            answer[i] = findRoom(room_number[i]);
        }
        
        return answer;
    }
    
    public long findRoom(long number){
        
        if(!room.containsKey(number)){
            room.put(number, number+1);
            return number;
        }
        
        long next = findRoom(room.get(number));
        room.put(number, next);
        return next;
        
    }
}