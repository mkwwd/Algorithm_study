import java.util.*;

class Solution {
    
    static boolean visited[];
    static int N, answer;
    static ArrayList<Integer> list;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        N = dungeons.length;
        list = new ArrayList<>();
        answer = 0;
        permutation(dungeons, 0, k);
        
        return answer;
    }
    
    public void permutation(int[][] dungeons, int cnt, int K){
        
        if(cnt == N){
            int stress = K;
            int go = 0;
            for(int i=0; i<list.size(); i++){
                int now = list.get(i);
                if(dungeons[now][0] <= stress){
                    stress -= dungeons[now][1];
                    go++;
                }else break;
            }
            answer = Math.max(answer, go);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(i);
            permutation(dungeons, cnt+1, K);
            visited[i] = false;
            list.remove(list.size()-1);
        }
        
    }

}