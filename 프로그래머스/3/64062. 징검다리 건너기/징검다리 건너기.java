class Solution {
    public int solution(int[] stones, int k) {
        
        int min = 0;
        int max = 200000000;
        
        while(min<=max){
            
            int mid = (max + min)/2;
            
            if(!isPossible(mid, stones, k)){
                max = mid-1;
            }else{
                min = mid+1;
            }
            
        }
        
        return max;
    }
    
    public static boolean isPossible(int mid, int[] stones, int k){
        int cnt = 0;
        
        for(int i=0; i<stones.length; i++){
            if(stones[i] >= mid){
                cnt = 0;
            }else{
                cnt ++;
            }
            if(cnt == k) return false;
        }
        
        return true;
    }
}