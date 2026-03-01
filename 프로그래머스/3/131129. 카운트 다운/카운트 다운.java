class Solution {
    public int[] solution(int target) {
        
        int dp[][] = new int[target+1][2];
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        for(int i=1; i<=target; i++){
            if(i <= 20){
                dp[i][0] = 1;
                dp[i][1] = 1;
            }else if(i == 50){
                dp[i][0] = 1;
                dp[i][1] = 1;
            }else if(i%2 == 0 && i<= 40){
                dp[i][0] = 1;
                dp[i][1] = 0;
            }else if(i%3 == 0 && i<=60){
                dp[i][0] = 1;
                dp[i][1] = 0;
            }else{
                for(int j=1; j<i; j++){
                    if(j > 60) break;
                    int shoot = dp[j][0] + dp[i-j][0];
                    int singleBool = dp[j][1] + dp[i-j][1];
                    
                    if(shoot < dp[i][0]){
                        dp[i][0] = shoot;
                        dp[i][1] = singleBool;
                    }else if(shoot == dp[i][0] && dp[i][1] < singleBool){
                        dp[i][1] = singleBool;
                    }
                }
            }
        }

        return dp[target];
    }
}