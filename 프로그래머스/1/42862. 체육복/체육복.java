import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        
        for(int i=0; i<lost.length; i++){
            lostSet.add(lost[i]);
        }
        
        for(int i=0; i<reserve.length; i++){
            if(lostSet.contains(reserve[i])){
                lostSet.remove(reserve[i]);
                continue;
            }
            reserveSet.add(reserve[i]);
        }
        
        int possible = n-lostSet.size();
        
        for(int item : lostSet){
            if(reserveSet.contains(item-1)){
                possible++;
                reserveSet.remove(item-1);
            }else if(reserveSet.contains(item+1)){
                possible++;
                reserveSet.remove(item+1);
            }
        }
    
        return possible;
    }
}