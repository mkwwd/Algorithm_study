import java.util.*;

public class Main {

    public static int st[] = new int[2];
    public static int end[] = new int[2];
    public static ArrayList<int[]> coins = new ArrayList<>();
    public static ArrayList<int[]> select = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j=0; j < N; j++){
                char ch = str.charAt(j);
                if(ch == 'S'){
                    st[0] = i;
                    st[1] = j;
                }else if(ch == 'E'){
                    end[0] = i;
                    end[1] = j;
                }else if('1' <= ch && ch <= '9'){
                    coins.add(new int[] {ch -'0', i, j});
                }
            }
        }
        
        if(coins.size() < 3){
            answer = -1;
        }else{
            coins.sort((a, b) -> Integer.compare(a[0] , b[0]));
            calculation(0, 0);
        }

        System.out.println(answer);
    }

    public static void calculation(int st, int cnt){

        if(cnt == 3){
            int dis = getDis();
            answer = Math.min(answer, dis);
            return;
        }

        for(int i=st; i<coins.size(); i++){
            select.add(coins.get(i));
            calculation(i+1, cnt+1);
            select.remove(select.size()-1);
        }
    }

    public static int getDis(){
        int total = 0;
        int stX = st[0];
        int stY = st[1];
        for(int i=0; i<3; i++){
            int next[] = select.get(i);
            total += Math.abs(next[1]-stX) + Math.abs(next[2]-stY);
            stX = next[1];
            stY = next[2];
        }
        total += Math.abs(stX - end[0]) + Math.abs(stY - end[1]);
        return total;
    }
}