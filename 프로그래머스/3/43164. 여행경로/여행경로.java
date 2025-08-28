import java.util.*;

class Solution {
    
    static boolean visited[];
    static boolean find = false;
    static ArrayList<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        ArrayList<String> list = new ArrayList<>();
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String o1[], String o2[]){
                return o1[1].compareTo(o2[1]);
            }
        });
            
        list.add("ICN");
        
        dfs("ICN", list, tickets);

        return answer.toArray(new String[answer.size()]);
    }
    
    public void dfs(String now, ArrayList<String> list, String[][] tickets){
        
        if(tickets.length+1 == list.size()){
            answer = new ArrayList<>(list);
            find = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!tickets[i][0].equals(now)) continue;
            if(visited[i]) continue;
            visited[i] = true;
            list.add(tickets[i][1]);
            dfs(tickets[i][1], list, tickets);
            if(find) return;
            visited[i] = false;
            list.remove(list.size()-1);
        }
        
    }
    
}