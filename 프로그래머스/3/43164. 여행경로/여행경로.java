import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<String>> way = new HashMap<>();
    static int len;
    static ArrayList<String> answer = new ArrayList<>();
    static boolean find = false;
    
    public String[] solution(String[][] tickets) {
        
        len = tickets.length;
        
        for(int i=0; i<tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            way.putIfAbsent(from, new ArrayList<>());
            way.get(from).add(to);
        }
        
        for(String key : way.keySet()){
            Collections.sort(way.get(key));
        }
        
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list);

        return answer.toArray(new String[answer.size()]);
    }
    
    public void dfs(String now, ArrayList<String> list){
        
        if(list.size() == len+1){
            answer = new ArrayList<>(list);
            find = true;
            return;
        }
        
        if (!way.containsKey(now)) return;

        for(int i=0; i<way.get(now).size(); i++){
            String next = way.get(now).get(i);
            if(next == null) continue;
            
            way.get(now).set(i, null);
            list.add(next);
            
            dfs(next, list);
            if(find) return;
            
            way.get(now).set(i, next);
            list.remove(list.size()-1);
        }       
        
        
    }
}