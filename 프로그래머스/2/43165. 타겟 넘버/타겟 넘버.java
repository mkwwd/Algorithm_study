class Solution {
    
    static int answer = 0;
        
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int index, int sum, int[] num, int result){
        
        if(index == num.length){
            if(sum == result) answer++;
            return;
        }
        
        dfs(index +1, sum + num[index], num, result);
        dfs(index +1, sum - num[index], num, result);
        
    }
}
