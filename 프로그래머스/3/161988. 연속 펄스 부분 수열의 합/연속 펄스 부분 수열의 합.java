class Solution {
    public long solution(int[] sequence) {
        
        int len = sequence.length;
        
        long dp[][] = new long[len][2];
        
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][1], 0) + sequence[i];
            dp[i][1] = Math.max(dp[i-1][0], 0) - sequence[i];
        }
        
        long answer = 0;
        
        for(long[] arr : dp){
            answer = Math.max(answer, Math.max(arr[0], arr[1]));
        }
        
        return answer;
    }
}