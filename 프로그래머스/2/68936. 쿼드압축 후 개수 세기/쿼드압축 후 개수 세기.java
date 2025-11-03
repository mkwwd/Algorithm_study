class Solution {
    
    static int answer[] = new int[2];
    
    public int[] solution(int[][] arr) {
        
        int N = arr.length;
        
        int ans = compression(0, 0, N, arr);
        
        if(ans == 0){
            answer[0] = 1;
        }
        
        if(ans == 1){
            answer[1] = 1;
        }
          
        return answer;
    }
    
    public int compression(int x, int y, int N, int[][] arr){
        
        if(N == 1){
            if(arr[x][y] == 1) return 1;
            if(arr[x][y] == 0) return 0;
        }
        
        int cntOne = 0;
        int cntZero = 0;
        
        int dx[] = {0, 0, N/2, N/2};
        int dy[] = {0, N/2, 0, N/2};
        
        for(int i=0; i<4; i++){
            int cnt = compression(x + dx[i], y + dy[i], N/2, arr);
            if(cnt == 1) cntOne++;
            if(cnt == 0) cntZero++;
        }
        
        if(cntOne == 4) return 1;
        if(cntZero == 4) return 0;
        
        answer[0] += cntZero;
        answer[1] += cntOne;
        
        return -1;    
    }


}