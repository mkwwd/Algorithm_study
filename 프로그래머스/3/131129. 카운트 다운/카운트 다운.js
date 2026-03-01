function solution(target) {
    
    const dp = Array.from({length:target + 1}, () => Array(2).fill(0));
    
    for(let i=0; i<target+1; i++){
        dp[i][0] = Number.MAX_SAFE_INTEGER;
    }
    
    for(let i=1; i<target+1; i++){
        if(i <= 20){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }else if(i == 50){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }else if(i%2 == 0 && i<=40){
            dp[i][0] = 1;
            dp[i][1] = 0;
        }else if(i%3 == 0 && i<=60){
            dp[i][0] = 1;
            dp[i][1] = 0;
        }else{
            for(let j=1; j<i; j++){
                if(j > 60) break;
                var shoot = dp[j][0] + dp[i-j][0];
                var singleBool = dp[j][1] + dp[i-j][1];
                if(shoot < dp[i][0]){
                    dp[i][0] = shoot;
                    dp[i][1] = singleBool;
                }else if(shoot == dp[i][0] && singleBool > dp[i][1]){
                    dp[i][1] = singleBool;
                }
            }
        }
    }
    
    return dp[target];
}