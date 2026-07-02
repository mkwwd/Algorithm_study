import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String, Integer> list = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            list.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                sum += list.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}