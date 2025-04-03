import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        TreeSet<Integer> arr = new TreeSet<>();
        Deque<Integer> trash = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            arr.add(i);
        }
        
        int index = k;
        
        for(int i=0; i<cmd.length; i++){
            st = new StringTokenizer(cmd[i]);
            String str = st.nextToken();
            if(str.equals("D")){
                int size = Integer.parseInt(st.nextToken());
                while(size-- > 0) index = arr.higher(index);
            }else if(str.equals("U")){
                int size = Integer.parseInt(st.nextToken());
                while(size-- > 0) index = arr.lower(index);
            }else if(str.equals("C")){
                trash.add(index);
                arr.remove(index);
                if(arr.higher(index) != null){
                    index = arr.higher(index);
                }else{
                    index = arr.lower(index);
                }
            }else{
                arr.add(trash.pollLast());
            }
        }
        
        for(int i=0; i<n; i++){
            if(arr.contains(i)){
                sb.append("O");
                arr.remove(0);
            }else{
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}