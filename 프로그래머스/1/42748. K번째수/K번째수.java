import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int answer[] = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int st = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2];
            int cut[] = Arrays.copyOfRange(array, st, end);
            Arrays.sort(cut);
            answer[i] = cut[k-1];
        }
        
        return answer;
    }
}