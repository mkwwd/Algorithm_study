import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int arr[] = new int[citations.length];
        
        for(int i=0; i<citations.length; i++){
            arr[i] = citations[citations.length-i-1];
        }
        
        int answer = 0;
        
        for(int i=0; i<citations.length; i++){
            if(arr[i] <= i) {
                answer = i;
                return answer;
            }
        }
        
        return citations.length;
    }
}