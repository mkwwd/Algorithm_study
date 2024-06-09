import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    
    static int N, M, H, dif;
    static int box[][][];
    static int dx[] = {-1, 0, 1, 0, 0, 0}, dy[] = {0, 1, 0, -1, 0, 0}, dz[] = {0, 0, 0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        Deque<int[]> ripe = new ArrayDeque<>();
        
        for(int i=0 ;i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                	int egg = Integer.parseInt(st.nextToken());
                    box[i][j][k] = egg;
                    if(egg == 1) {
                    	ripe.add(new int[] {i, j, k});
                    }
                }
            }
        }
        
        int day = 0;
        int size = ripe.size();
        
        while(size >= 0) {

        	int cnt = 0;
        	
        	while(cnt < size) {
        		// 익은 토마토 하나
        		int ripeTomato[] = ripe.poll();
        		int h = ripeTomato[0];
        		int n = ripeTomato[1];
        		int m = ripeTomato[2];
        		// 익은 계란 근처에 안익은 토마토 있나 확인
                for(int i=0; i<6; i++) {
                    int newX = n+dx[i];
                    int newY = m+dy[i];
                    int newZ = h+dz[i];
                    if(newX<0 || newX>=N || newY<0 || newY>=M || newZ<0 || newZ>=H) continue; 
                    // 범위이면 멀쩡토마토 인지 확인, 아니면 다음
                    if(box[newZ][newX][newY]!=0) continue;
                    // 멀쩡토마토이고 방문안했으면 익힌후에 방문처리하고 ripeEgg에 집어넣자
                    box[newZ][newX][newY] = 1;
                    ripe.add(new int[] {newZ, newX, newY});
                }
                
                cnt ++;
        	}
        	// 익은 토마토 갯수 확인
        	size = ripe.size();
        	// 익은 토마토가 더 이상 없다면
        	if(size == 0) {
        		// 남은 안익토 계산
        		int toma = check();
        		// 남은 안익토가 있으면 -1
        		if(toma != 0) {
        			day = -1;
        		}
        		break;
        	}else {        		
        		day++;
        	}
        	
        }
        
        
        System.out.println(day);
   }
        


    private static int check() {
        
        int toma = 0;
        
        for(int i=0 ;i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0) toma++;
                }
            }
        }
        
        return toma;
    }


}
