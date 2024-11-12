import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ansList = new ArrayList<Integer>();
   
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0; 
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == stu1[i%stu1.length]) ans1 ++;
            if(answers[i] == stu2[i%stu2.length]) ans2 ++;
            if(answers[i] == stu3[i%stu3.length]) ans3 ++;
        }
        
        int max = Math.max(ans1, Math.max(ans2, ans3));
        
        if(max == ans1) ansList.add(1);
        if(max == ans2) ansList.add(2);
        if(max == ans3) ansList.add(3);
        
        int result[] = new int[ansList.size()];
        
        for(int i=0; i<ansList.size(); i++){
            result[i] = ansList.get(i);
        }
        
        return result;
    }
}