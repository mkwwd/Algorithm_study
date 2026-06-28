import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<score.length; i++){
            pq.add(score[i]);
        }
        
        int max = k;
        int answer = 0;
        
        while(pq.size() >= m){
            for(int i=0; i<m; i++){
                max = Math.min(max, pq.poll());
            }
            answer += max*m;
        }
        
        return answer;
    }
}