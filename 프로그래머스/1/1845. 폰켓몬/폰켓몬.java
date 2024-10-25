import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int N = nums.length;
        
        TreeMap<Integer, Integer> pokemon = new TreeMap<>();

        for(int i=0; i<N; i++){
            pokemon.put(nums[i], pokemon.getOrDefault(nums[i], 0) + 1);
        }
        
        int size = pokemon.size();
        int answer = 0;
            
        if(size <= N/2){
            answer = size;
        }else{
            answer = N/2;
        }
        
        return answer;
    }
}