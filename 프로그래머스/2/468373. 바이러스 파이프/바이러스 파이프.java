import java.util.*;

class Solution {
    
    static int answer = 0;
    ArrayList<ArrayList<int[]>> node;
    static boolean visited[];
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        node = new ArrayList<>();
        visited = new boolean[n+1];
        
        for(int i=0; i<n+1; i++){
            node.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int type = edges[i][2];
            node.get(from).add(new int[]{to, type});
            node.get(to).add(new int[]{from, type});
        }
        
        ArrayList<Integer> infect = new ArrayList<>();
        
        infect.add(infection);

        dfs(infect, 0, k);
        
        return answer;
    }
    
    public void dfs(ArrayList<Integer> infect, int type, int cnt){
        
        
        if(cnt < 0) return;
        answer = Math.max(answer, infect.size());
        
        ArrayList<Integer> pipeA = new ArrayList<>(infect);
        ArrayList<Integer> pipeB = new ArrayList<>(infect);
        ArrayList<Integer> pipeC = new ArrayList<>(infect);
        
        int cntA = (type == 1) ? cnt : cnt-1;
        int cntB = (type == 2) ? cnt : cnt-1;
        int cntC = (type == 3) ? cnt : cnt-1;
         
        for(int i=0; i<infect.size(); i++){
            // 지금 노드 기준으로 열려있는 파이프 탐색
            int now = infect.get(i);
            for(int info[] : node.get(now)){
                int next = info[0];
                int tp = info[1];
                if(infect.contains(next)) continue;
                if(tp == 1){
                    pipeA.add(next);
                }else if(tp == 2){
                    pipeB.add(next);
                }else{
                    pipeC.add(next);
                }
            }
        }

        if(infect.size() != pipeA.size()) dfs(pipeA, 1, cntA);
        if(infect.size() != pipeB.size()) dfs(pipeB, 2, cntB);
        if(infect.size() != pipeC.size()) dfs(pipeC, 3, cntC);
        
    }
}