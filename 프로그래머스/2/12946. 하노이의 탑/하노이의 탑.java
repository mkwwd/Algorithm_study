import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
    public void hanoi(int n, int from, int by, int to){
        if(n == 1){
            list.add(new int[]{from, to});
            return;
        }
        // n-1개 1에서 2로 보내기
        hanoi(n-1, from, to, by);
        // n번째 1에서 3으로 보내기 
        list.add(new int[] {from, to});
        // 2에 있는거 3으로 보내기
        hanoi(n-1, by, from, to);
    }
}