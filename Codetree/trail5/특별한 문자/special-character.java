import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int cnt[] = new int[128];

        for(int i=0; i<str.length(); i++){
            cnt[str.charAt(i)]++;
        }

        for(int i=0; i<str.length(); i++){
            if(cnt[str.charAt(i)] == 1){
                System.out.println(str.charAt(i));
                return;
            }
        }

        System.out.println("None");

    }
}