import java.util.*;

class Solution {
    
    static int sheep, wolf, answer = 0;
    static ArrayList<ArrayList<Integer>> arr;
    
    public int solution(int[] info, int[][] edges) {
        
        arr = new ArrayList<>();
        
        for(int i=0; i<info.length; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int pa = edges[i][0];
            int ch = edges[i][1];
            arr.get(pa).add(ch);
        }
        
        ArrayList<Integer> node = new ArrayList<>();
        
        dfs(node, info, 0, 0, 0);
        
        return answer;

    }
    
    static void dfs(ArrayList<Integer> node, int[] info, int st, int sheep, int wolf){
        
        if(info[st] == 0) sheep++;
        else wolf ++;
        
        if(sheep <= wolf) return;
        
        answer = Math.max(answer, sheep);
        
        ArrayList<Integer> nextNode = new ArrayList<>(node);
        nextNode.remove(Integer.valueOf(st));
        
        for(int child : arr.get(st)){
            nextNode.add(child);
        }
        
        for(Integer next : nextNode){
            dfs(nextNode, info, next, sheep, wolf);
        }
        
    }
}