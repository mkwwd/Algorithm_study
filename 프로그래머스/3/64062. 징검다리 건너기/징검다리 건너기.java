class Solution {
    public int solution(int[] stones, int k) {
        
        int min = 0;
        int max = 200000000;
        
        while(min <= max){
            
            int mid = (min + max)/2;
            
            if(checkStone(mid, k, stones)){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            
        }
        
        return max;
    }
    
    public static boolean checkStone(int mid, int k, int[] stones){
        
        int cnt = 0;
        
        for(int i=0; i<stones.length; i++){
            if(stones[i] - mid < 0){
                cnt++;
            }else cnt = 0;
            
            if(cnt >= k) return false;
        }
        
        return true;
    }
}