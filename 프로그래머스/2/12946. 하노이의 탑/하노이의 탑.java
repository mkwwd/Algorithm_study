import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        int answer[][] = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int n, int from, int ex, int to){
        
        if(n==1) {
            list.add(new int[]{from, to});
            return;
        }
        
        // 맨 마지막 원반을 제외한 원반을 2번으로
        hanoi(n-1, from, to, ex);
        // 맨 마지막 원반을 3번으로
        list.add(new int[]{from, to});
        // 2번에 있는 원반들을 3번으로
        hanoi(n-1, ex, from, to);
        
    };
    
  
}