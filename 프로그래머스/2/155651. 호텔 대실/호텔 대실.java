import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String o1[], String o2[]){
                if(!o1[0].equals(o2[0])){
                    return o1[0].compareTo(o2[0]);
                }
                return o1[1].compareTo(o2[1]);
            }
        });
        
        PriorityQueue<Integer> room = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++){
            String guest[] = book_time[i];
            String start[] = guest[0].split(":");
            String end[] = guest[1].split(":");
            int stTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
            if(room.isEmpty()){
                room.add(endTime+10);
            }else{
                if(room.peek() <= stTime){
                    room.poll(); 
                }
                room.add(endTime+10);
            }
        }
        
        return room.size();
    }
}