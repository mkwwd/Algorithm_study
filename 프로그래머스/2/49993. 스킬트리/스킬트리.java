import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        ArrayList<Character> str = new ArrayList<>();
        
        for(int i=0; i<skill.length(); i++){
            str.add(skill.charAt(i));
        }
        
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String trees = skill_trees[i];
            int index = 0;
            boolean isPossible = true;
            for(int j=0; j<trees.length(); j++){
                char now = trees.charAt(j);
                if(!str.contains(now)) continue;
                if(str.indexOf(now) == index){
                    index ++;
                }else{
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) answer++;
            
        }
        
        return answer;
    }
}