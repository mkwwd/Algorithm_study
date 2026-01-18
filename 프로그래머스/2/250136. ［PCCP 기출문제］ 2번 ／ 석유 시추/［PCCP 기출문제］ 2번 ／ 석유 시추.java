import java.util.*; 

class Solution {
    
    static int n, m;
    static boolean visited[][];
    static int ground[][];
    static int[] dx=new int[]{0,0,-1,1};
    static int[] dy=new int[]{-1,1,0,0};
    static HashMap<Integer, Integer> oil = new HashMap<>();

    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        ground = new int[n][m];
        int index = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]) continue;
                if(land[i][j] == 0) continue;
                findOil(land, i, j, index);
                index++;
            }
        }
        
        int max = 0;
        HashSet<Integer> get;
        
        for(int i=0; i<m; i++){
            get = new HashSet<>();
            int sum = 0;
            for(int j=0; j<n; j++){
                if(ground[j][i] != 0){
                    get.add(ground[j][i]);
                }
            }
            for(int amount : get){
                sum += oil.get(amount);
            }

            max = Math.max(sum, max);
            
        }
        
        return max;
    }
    
    public void findOil(int[][] land, int x, int y, int index){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        visited[x][y] = true;
        ground[x][y] = index;
        int sum = 1;
        
        while(!que.isEmpty()){
            
            int now[] = que.poll();
            
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;
                if(visited[nextX][nextY]) continue;
                if(land[nextX][nextY] == 0) continue;
                que.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                ground[nextX][nextY] = index;
                sum++;
            }
            
        }
        
        oil.put(index, sum);
        
    }
    
    
} 