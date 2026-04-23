class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        
        long r1 = x;
        long r2 = x;
        long c1 = y;
        long c2 = y;
        
        for(int i=queries.length-1; i>=0; i--){
            int dir = queries[i][0];
            int dist = queries[i][1];
            if(dir == 0){ // 열 번호 증가 ++, c++
                if(c1 != 0) c1 += dist;
                c2 = Math.min(m-1, c2 + dist);
            }else if(dir == 1){ // 열 번호 감소 --, c--
                c1 = Math.max(0, c1 - dist);
                if(c2 != m-1) c2 -= dist;
            }else if(dir == 2){ // 행 번호 증가 ++, r++
                if(r1 != 0) r1 += dist;
                r2 = Math.min(n-1, r2 + dist);
            }else{ // 행 번호 감소 --, r--
                r1 = Math.max(0, r1 - dist);
                if(r2 != n-1) r2 -= dist;
            }
            
            if(r1 > r2 || c1 > c2) return 0;
        }

        return (r2 - r1 + 1) * (c2 - c1 + 1);
    }
}