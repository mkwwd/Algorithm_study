import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int player[][] = new int[n+1][n+1];
        for(int i=0; i<results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            player[win][lose] = 1;
        }
        
        int answer = 0;
        
        for(int i=1; i<n+1; i++){
            Deque<Integer> que = new ArrayDeque<>();
            que.add(i);
            boolean check[] = new boolean[n+1];
            check[i] = true;
            int cnt = 0;
            while(!que.isEmpty()){
                int now = que.poll();
                for(int j=1; j<n+1; j++){
                    if(player[now][j] == 0) continue;
                    if(check[j]) continue;
                    check[j] = true;
                    que.add(j);
                    cnt++;
                }
            }
            
            que.add(i);
            check = new boolean[n+1];
            check[i] = true;
            
            while(!que.isEmpty()){
                int now = que.poll();
                for(int j=1; j<n+1; j++){
                    if(player[j][now] == 0) continue;
                    if(check[j]) continue;
                    check[j] = true;
                    que.add(j);
                    cnt++;
                }
            }
            
            if(cnt == n-1){
                answer++;
            }

        }
        
        return answer;
    }
}