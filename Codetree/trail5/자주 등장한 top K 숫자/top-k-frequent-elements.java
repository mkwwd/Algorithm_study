import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                if(o1[1] == o2[1]) return o2[0] - o1[0];
                return o2[1]-o1[1];
            }
        });
        
        map.forEach((key, value) -> {
            pq.add(new int[]{key, value});
        });

        for(int i=0; i<k; i++){
            int[] out = pq.poll();
            System.out.print(out[0] + " ");
        }
    } 
}