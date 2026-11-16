import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!hash.containsKey(x)){
                hash.put(x, y);
            }else if(hash.get(x) > y){
                hash.put(x, y);
            }
        }

        long answer = 0;

        for(Integer val : hash.values()){
            answer += val;
        }

        System.out.println(answer);
    }
}