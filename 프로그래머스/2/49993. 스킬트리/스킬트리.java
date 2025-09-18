import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        ArrayList<Character> turn = new ArrayList<>();
        
        for(int i=0; i<skill.length(); i++){
            turn.add(skill.charAt(i));
        }
            
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            int index = 0;
            String now = skill_trees[i];
            boolean possible = true;
            for(int j=0; j<now.length(); j++){
                if(turn.contains(now.charAt(j))){
                    if(turn.get(index) == (now.charAt(j))){
                        index++;
                    }else{
                        possible = false;
                        break;
                    }
                }
            }
            if(possible) answer++;
        }
        
        return answer;
    }
}