import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
    static int player[][], lineUp[], T, max, count;
    static ArrayDeque<Integer> hit;
    static boolean used[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        player = new int[T][9];
        
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        used = new boolean[9];
        used[0] = true;
        lineUp = new int[9];
        
        max = 0;
        makeList(0);
        
        System.out.println(max);

    }

    private static void makeList(int cnt) {
        
        if(cnt == 3) {
            lineUp[cnt] = 0;
            makeList(cnt+1);
        }if(cnt == 9){
            playGame(lineUp);
            return;
        }else {            
            for(int i=0; i<9; i++) {
                if(used[i]) continue;
                used[i] = true;
                lineUp[cnt] = i;
                makeList(cnt+1);
                used[i] = false;
            }
        }
    }

    private static void playGame(int[] lineUp) {
        
        count = 0;

        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        for(int i=0; i<lineUp.length; i++) {
            que.add(lineUp[i]);
        }
        
        for(int i=0; i<T; i++) {
            
            hit = new ArrayDeque<>();
            int out = 0;
            while(out < 3) {
                
                int currentPlayer = que.poll();
                int play = player[i][currentPlayer];
                que.add(currentPlayer);
                
                switch(play) {
                
                case 1:
                    isHome(1);
                    hit.add(1);
                    break;
                case 2:
                    isHome(2);
                    hit.add(2);
                    break;
                case 3:
                    isHome(3);
                    hit.add(3);
                    break;
                case 4:
                    hit.add(4);
                    isHome(4);
                    break;
                case 0:
                    out ++;
                    break;
                }    
            }            
        }    
        max = Math.max(max, count);
        
    }

    private static void isHome(int run) {
        int size = hit.size();
        for(int j=0; j<size; j++) {
            int now = hit.poll();
            now = now + run;
            if(now >= 4) {                
                count++;
                continue;
            }
            hit.add(now);
        }
        
    }

}