import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int nowA = 0;
        int answer = 0;
        
        for(int i=0; i<B.length; i++){
            if(B[i] > A[nowA]){
                answer++;
                nowA++;
            }
        }
            
        
        return answer;
    }
}