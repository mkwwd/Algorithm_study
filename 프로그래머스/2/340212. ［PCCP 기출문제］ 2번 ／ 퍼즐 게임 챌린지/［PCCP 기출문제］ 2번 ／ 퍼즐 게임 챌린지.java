class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int min = 1;
        int max = 300000;
        
        while(min <= max){
            int mid = (min + max)/2;
            boolean isPossible = solvePuzzle(mid, diffs, times, limit);
            if(isPossible){
                max = mid -1;
            }else{
                min = mid + 1;
            }
            
        }
        
        return min;
    }
    
    public static boolean solvePuzzle(int mid, int[] diffs, int[] times, long limit){
        
        long sum = 0;
        for(int i=0; i<diffs.length; i++){
            if(mid >= diffs[i]){
                sum += times[i];
            }else{
                int gap = diffs[i] - mid;
                sum += (times[i-1]+times[i])*gap + times[i];
            }
            
            if(sum > limit) return false;
        }
        
        return true;
        
        
    }
}