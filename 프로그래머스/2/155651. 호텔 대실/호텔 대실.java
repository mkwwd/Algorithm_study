import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int time[][] = new int[book_time.length][book_time[0].length];
        
        for(int i=0; i<book_time.length; i++){
            for(int j=0; j<book_time[0].length; j++){
                int hour = Integer.parseInt(book_time[i][j].substring(0, 2));
                int minute = Integer.parseInt(book_time[i][j].substring(3, 5));
                time[i][j] = hour*60 + minute;
            }
        }
        
        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        pq.add(new int[]{time[0][0], time[0][1]});
        
        for(int i=1; i<time.length; i++){
            int now[] = pq.peek();
            if(now[1] + 10 <= time[i][0]){
                pq.poll();   
            }
            pq.add(new int[]{time[i][0], time[i][1]});
        }
            
        int answer = pq.size();
        return answer;
    }
}