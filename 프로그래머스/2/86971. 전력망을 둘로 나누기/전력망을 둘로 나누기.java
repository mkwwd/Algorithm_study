import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        int line[][] = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            for(int j=0; j<2; j++){
                line[wires[i][0]][wires[i][1]] = 1;
                line[wires[i][1]][wires[i][0]] = 1;
            }
        }
        
        int answer = n;
        
        for(int i=0; i<wires.length; i++){
            int areaA = checkNode(wires[i][0], wires[i][1], line);
            int areaB = checkNode(wires[i][1], wires[i][0], line);
            answer = Math.min(answer, Math.abs(areaA-areaB));
        }
        
        return answer;
    }
    
    public static int checkNode(int edge, int cut, int[][] line){
        int cnt = 1;
        boolean check[] = new boolean[line.length];
        check[edge] = true;
        check[cut] = true;
        Deque<Integer> que = new ArrayDeque<>();
        que.add(edge);
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=1; i<line.length; i++){
                if(line[now][i] != 1) continue;
                if(check[i]) continue;
                check[i] = true;
                cnt++;
                que.add(i);
            }
        }
        
        return cnt;
        
    }
    
}