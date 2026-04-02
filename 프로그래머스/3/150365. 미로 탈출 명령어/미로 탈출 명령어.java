class Solution {
    
    static int[] dx={1, 0, 0, -1}, dy={0, -1, 1, 0};
    static char[] dir={'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int stX = x-1;
        int stY = y-1;
        int endX = r-1;
        int endY = c-1;
        
        int dist = Math.abs(endX - stX) + Math.abs(endY-stY);
        if(dist > k || (k-dist)%2 != 0) return "impossible";
        
        for(int i=0; i<k; i++){
            for(int j=0; j<4; j++){
                int nextX = stX + dx[j];
                int nextY = stY + dy[j];
                
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                
                int remain = k - (i + 1);
                int nextDist = Math.abs(nextX - endX) + Math.abs(nextY - endY);
                
                if(nextDist <= remain && (remain - nextDist)%2 == 0){
                    sb.append(dir[j]);
                    stX = nextX;
                    stY = nextY;
                }
            }
        }
        
        return sb.toString();
    }
    
}