class Solution {
    
    static boolean visited[];
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            answer++;
            connect(i, computers);
        }
         
        return answer;
    }
    
    public void connect(int st, int[][] computers){
        
        for(int i=0; i<computers.length; i++){
            if(computers[st][i] == 1 && !visited[i]){
                visited[i] = true;
                connect(i, computers);
            }
        }
        
    }

}