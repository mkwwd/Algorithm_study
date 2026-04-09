import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String input = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(input.equals("I")){
                tree.put(num, tree.getOrDefault(num, 0)+1);
            }else{
                if(tree.isEmpty()) continue;
                if(num == 1){
                    if(tree.get(tree.lastKey()) == 1){
                        tree.remove(tree.lastKey());
                    }else{
                        tree.put(tree.lastKey(), tree.get(tree.lastKey())-1);
                    }
                }else{
                    if(tree.get(tree.firstKey()) == 1){
                        tree.remove(tree.firstKey());
                    }else{
                        tree.put(tree.firstKey(), tree.get(tree.firstKey())-1);
                    }
                }
            }
        }
        
        int answer[] = tree.isEmpty()? new int [] {0,0}: new int[] {tree.lastKey(), tree.firstKey()};
        
        return answer;
    }
}