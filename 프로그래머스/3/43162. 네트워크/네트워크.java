class Solution {
    
    static boolean connect[];
    
    public int solution(int n, int[][] computers) {
        
        connect = new boolean [n];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!connect[i]){
                answer++;
                network(i, computers);
            }
        }
        
        return answer;
    }
    
    public void network(int start, int[][] arr){
        for(int i=0; i<arr.length; i++){
            if(!connect[i] && arr[start][i] == 1 && start != i){
                connect[i] = true;
                network(i, arr);
            }
        }
    }
}