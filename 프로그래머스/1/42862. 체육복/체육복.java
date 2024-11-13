import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int student[] = new int[n+1];
        Arrays.fill(student, 1);
        int answer = 0;
        
        for(int i=0; i<reserve.length; i++){
            student[reserve[i]] = 2;
        }
        
        for(int i=0; i<lost.length; i++){
            student[lost[i]]--;
        }
        
        for(int i=1; i<=n; i++){
            if(student[i] >= 1) continue;
            if(student[i-1] > 1){
                student[i-1]--;
                student[i] ++;
                continue;
            }
            if(i+1 < student.length && student[i+1] > 1){
                student[i+1]--;
                student[i] ++;
                continue;
            }
            
            answer++;
        }
    
        return n-answer;
    }
}