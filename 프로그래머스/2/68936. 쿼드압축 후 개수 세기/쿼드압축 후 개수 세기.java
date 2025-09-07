class Solution {
    
    static int answer[] = new int[2];
    
    public int[] solution(int[][] arr) {
        
        int N = arr.length;
        
        int ans = compression(0, 0, N, arr);
        
        if(ans == 1){
            answer[1] = 1;
        }
        if(ans == 0){
            answer[0] = 1;
        }
        
        return answer;
    }
    
    public int compression(int x, int y, int N, int[][] arr){
        
        if(N == 1 && arr[x][y] == 1){
            return 1;
        }else if(N == 1 && arr[x][y] == 0){
            return 0;
        }
        
        int one = 0;
        int zero = 0;

        int dx[] = {0, N/2, 0, N/2};
        int dy[] = {0, 0, N/2, N/2};
        
        for(int i=0; i<4; i++){
            int result = compression(x+dx[i], y+dy[i], N/2, arr);
            if(result == 1) one++;
            else if(result == 0) zero++;
        }
        
        if(one == 4) return 1;
        if(zero == 4) return 0;
        
        answer[1] += one;
        answer[0] += zero;
        return -1;
        
    }

}