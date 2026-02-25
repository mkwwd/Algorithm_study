import java.util.*;

class Solution {
    
    static List<Integer> list = new ArrayList<>();
    static int answer = 0; 
    static int sum = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        combination(1, n, q, ans);

        return answer;
    }
    
    public void combination(int st, int n, int[][] q, int[] ans){
        
        if(list.size() == 5){
            if(isValid(list, q, ans)) answer++;
            sum ++;
            return;
        }
        
        for(int i=st; i<=n; i++){
            list.add(i);
            combination(i+1, n, q, ans);
            list.remove(list.size() - 1);
        }
        
    }
    
    public boolean isValid(List<Integer> list, int[][] q, int[] ans){
        
        for(int i=0; i<q.length; i++){
            int cnt = 0;
            for(int j=0; j<5; j++){
                if(list.contains(q[i][j])) cnt++;
            }
            if(cnt != ans[i]) return false;
        }
        
        return true;
        
    }
    
}