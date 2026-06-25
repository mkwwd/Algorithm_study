import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        Arrays.sort(arr);
        
        ArrayList<Integer> num = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0){
                num.add(arr[i]);
            }
        }
        
        int n = num.size();
        
        if(n == 0){
            return new int[] {-1};
        }
        
        int answer[] = new int[n];
        
        for(int i=0; i<n; i++){
            answer[i] = num.get(i);
        }
        
        return answer;
    }
}