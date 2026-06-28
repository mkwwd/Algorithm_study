import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<score.length; i++){
            pq.add(score[i]);
        }
        
        int min = k;
        int answer = 0;
        
        while(pq.size() >= m){
            for(int i=0; i<m; i++){
                min = Math.min(min, pq.poll());
            }
            answer += min*m;
        }
        
        return answer;
    }
}