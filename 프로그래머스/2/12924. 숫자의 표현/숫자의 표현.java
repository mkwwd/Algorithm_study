class Solution {
    public int solution(int n) {
        
        int left = 1;
        int right = 1;
        int sum = 1;
        int answer = 0;
        
        while(left <= right){
            if(sum <= n){
                if(sum == n) answer++;                
                right++;
                sum+=right;
            }else{
                sum -= left;
                left++;
            }
        }
        
        return answer;
    }
}