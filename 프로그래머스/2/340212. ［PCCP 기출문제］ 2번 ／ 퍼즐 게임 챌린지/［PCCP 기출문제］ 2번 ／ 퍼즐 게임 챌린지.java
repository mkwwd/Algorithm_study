class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int min = 1;
        int max = 300000;
        
        while(min <= max){
            int mid = (min+max)/2;
            if(isSolved(diffs, times, mid, limit)){
                max = mid -1;
            }else{
                min = mid + 1;
            }
        }
        
        return min;
    }
    
    public boolean isSolved(int[] diffs, int[] times, int mid, long limit){
        
        long sum = 0;
        
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= mid){
                sum += times[i];
            }else{
                sum += (times[i-1] + times[i])*(diffs[i] - mid) + times[i];
            }
        }
        
        if(sum <= limit) return true;
        return false;
    }

}