import java.util.*;

class Solution {
    
    static boolean visited[];
    static ArrayList<Integer> save = new ArrayList<>();    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        permutation(dungeons, k);
        
        return answer;
    }
    
    public static void permutation(int[][] dungeons, int k){
        
        if(save.size() == dungeons.length){
            int stress = k;
            int cnt = 0;
            for(int i=0; i<dungeons.length; i++){
                int now = save.get(i);
                if(dungeons[now][0] <= stress){
                    cnt ++;
                    stress -= dungeons[now][1];
                }
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            save.add(i);
            permutation(dungeons, k);
            visited[i] = false;
            save.remove(save.size() -1);
        }
        
    } 
}