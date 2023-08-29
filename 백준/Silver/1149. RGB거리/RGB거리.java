import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    static int house[][], paint[][], N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        house = new int[N][3];
        paint = new int[N][3];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 첫번째 값 세팅
        for(int i=0; i<3; i++) {
            paint[0][i] = house[0][i];    
        }
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                paint[i][j] = paintHouse(i, j);
            }
        }
        
        int min = 1000*N;
        
        for(int i=0; i<3; i++) {
            min = Math.min(min, paint[N-1][i]);
        }
        
        System.out.println(min);
        
    }

    private static int paintHouse(int x, int y) {
        
    	int min = 1000*N;
        
        for(int j=0; j<3; j++) {
        	if(j == y) continue;
            int sum = paint[x-1][j] + house[x][y];
            min = Math.min(min, sum);
        }
        
        return min;
    }
    
}