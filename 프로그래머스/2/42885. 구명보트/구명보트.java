import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int boat = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            
            right--;
            boat++;
        }
        
        return boat;
        
    }
}