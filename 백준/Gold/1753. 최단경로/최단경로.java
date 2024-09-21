import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        for(int i=0; i<V+1; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, value));
        }

        int min[] = new int[V+1];
        for(int i=1; i<V+1; i++){
            if(i == K) continue;
            min[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(K, 0));

        while(!que.isEmpty()){
            Node now = que.poll();
            int size = arr.get(now.v).size();
            for(int i=0; i<size; i++){
                Node next = arr.get(now.v).get(i);
                if(min[next.v] > min[now.v] + next.w){
                    min[next.v] = min[now.v] + next.w;
                    que.add(new Node(next.v, min[next.v]));
                }
            }
        }

        for(int i=1; i<V+1; i++){
            if(min[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(min[i]);
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n){
        return this.w - n.w;
    }
}