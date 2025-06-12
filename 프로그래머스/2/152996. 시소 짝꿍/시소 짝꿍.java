import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            double arr[] = {weights[i]*1.0, weights[i]*0.5, (weights[i]*2.0)/3.0, weights[i]*0.75};
            
            for(double num : arr){
               if(map.containsKey(num)) answer += map.get(num);
            }
            
            if(map.containsKey(weights[i]*1.0)){
                map.put(weights[i]*1.0, map.get(weights[i]*1.0) + 1);
            }else{
                map.put(weights[i]*1.0, 1);
            }
        }
        
        return answer;
    }
}