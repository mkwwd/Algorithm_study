import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        
        String[] arr = s.split(" ");
        
        TreeSet<Integer> que = new TreeSet<>();
        
        for(int i=0; i<arr.length; i++){
            que.add(Integer.parseInt(arr[i]));
        }
        
        String answer = que.first() + " " + que.last();
        
        return answer;
    }
}