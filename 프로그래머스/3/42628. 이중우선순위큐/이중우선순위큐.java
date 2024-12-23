import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String order = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(order.equals("I")){
                tree.put(num, tree.getOrDefault(num, 0) + 1);
            }else{
                if(tree.isEmpty()) continue;
                if(num == -1){
                    int min = tree.firstKey();
                    int cnt = tree.get(min);
                    if(cnt == 1){
                        tree.remove(min);
                    }else{
                        tree.put(min, cnt-1);
                    }
                }else{
                    int max = tree.lastKey();
                    int cnt = tree.get(max);
                    if(cnt == 1){
                        tree.remove(max);
                    }else{
                        tree.put(max, cnt-1);
                    }
                }
            }
        }
        
        
        int[] answer = tree.isEmpty()? new int[]{0, 0} : new int[]{tree.lastKey(), tree.firstKey()};
        return answer;
    }
}