import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> que = new ArrayDeque<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<n; i++){
            set.add(i);
        }
        
        for(int i=0; i<cmd.length; i++){
            st = new StringTokenizer(cmd[i]);
            String word = st.nextToken();
            if(word.equals("U")){
                int size = Integer.parseInt(st.nextToken());
                while(size > 0) {
                    k = set.lower(k);
                    size--;
                }
            }else if(word.equals("D")){
                int size = Integer.parseInt(st.nextToken());
                while(size > 0){
                    k = set.higher(k);
                    size--;
                }
            }else if(word.equals("C")){
                que.add(k);
                set.remove(k);
                if(set.higher(k) == null){
                    k = set.lower(k);
                }else{
                    k = set.higher(k);
                }
            }else{
                set.add(que.pollLast());
            }
        }
        
        for(int i=0; i<n; i++){
            if(set.contains(i)){
                sb.append("O");
            }else{
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}