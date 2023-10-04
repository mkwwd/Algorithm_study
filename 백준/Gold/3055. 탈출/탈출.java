import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
    static char forest[][];
    static int R,C, min=Integer.MAX_VALUE;
    static int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
    static ArrayDeque<int[]> waters, go;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        forest = new char[R][C];
        
        go = new ArrayDeque<>();
        waters = new ArrayDeque<>();
        
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                forest[i][j] = input.charAt(j);
                // 고슴도치 위치
                if(forest[i][j]=='S') {
                	go.add(new int[] {i,j,0});
                }
                // 물이 차있는 위치
                if(forest[i][j]=='*') {
                    waters.add(new int[] {i,j});
                }
            }            
        }
        
        start();        
        
        if(min==Integer.MAX_VALUE) {
        	System.out.println("KAKTUS");
        }else{        	
        	System.out.println(min);
        }

    }

    private static void start() {
        
    	while(!go.isEmpty()) {
    		
    		int size = waters.size();
    		for(int i=0; i<size; i++) {
    			int water[] = waters.poll();
    			// 퍼질 부분 큐에 넣기
    			for(int j=0; j<4; j++) {
    				int nextX = water[0]+dx[j];
    				int nextY = water[1]+dy[j];
    				if(nextX<0 || nextX>=R || nextY<0 || nextY>=C) continue;
    				if(forest[nextX][nextY]=='.') {
    					// 퍼질 부분이면  체크
    					forest[nextX][nextY]='*';
    					waters.add(new int[] {nextX, nextY});
    				}
    			}
    		}
    		
    		// 고슴도치가 갈 수 있는지 체크    		
    		size = go.size();
    		for(int i=0; i<size; i++) {
    			int gochi[] = go.poll();
    			int cnt = gochi[2];
    			// 갈 수 있는 방향 저장
    			for(int j=0; j<4; j++) {
    				int nextX = gochi[0]+dx[j];
    				int nextY = gochi[1]+dy[j];
    				if(nextX <0 || nextX>=R || nextY<0 || nextY>=C) continue;
    				// 비버의 굴인지 확인
    				if(forest[nextX][nextY]=='D') {
    					cnt ++;
    					min = Math.min(min, cnt);
    					return;
    				}else if(forest[nextX][nextY]=='.'){
    					forest[nextX][nextY] = 'S';
    					go.add(new int[] {nextX, nextY, cnt+1});
    				}
    			}
    			
    			
    		}
    	}
    	
    }

}
