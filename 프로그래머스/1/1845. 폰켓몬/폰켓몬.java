import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int get = nums.length/2;
        
        HashMap<Integer, Integer> pokemon = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int cnt = pokemon.getOrDefault(nums[i], 0);
            if(cnt == 0){
                pokemon.put(nums[i], 1);
            }else{
                pokemon.put(nums[i], pokemon.get(nums[i])+1);
            }
        }
        
        int size = pokemon.size();
        int answer = Math.min(size, get);
        
        return answer;
    }
}