class Solution {
    public int[] solution(int n) {
        
        int[][] snail = new int[n+1][n+1]; 
        
        int dirX[] = {1, 0, -1};
        int dirY[] = {0, 1, -1};
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;
        
        for(int i=n; i>0; i--){
            for(int j=0; j<i; j++){
                x += dirX[dir];
                y += dirY[dir];
                snail[x][y] = num;
                num++;
            }
            dir = (dir+1)%3;
        }
       
        int[] answer = new int[num-1];
        int index = 0;
        
        for(int i=1; i<n+1; i++){
            for(int j=0; j<i; j++){
                answer[index++] = snail[i][j];
            }
        }
        
        return answer;
    }
}