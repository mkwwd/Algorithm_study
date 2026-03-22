class Solution {
    
    static boolean connected[];
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        connected = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(connected[i]) continue;
            connected[i] = true;
            answer++;
            connect(i, computers);
        }
         
        return answer;
    }
    
    public void connect(int now, int[][] computers){
        
        for(int i=0; i<computers.length; i++){
            if(computers[now][i] == 1 && !connected[i]){
                connected[i] = true;
                connect(i, computers);
            }
        }
        
    }

}