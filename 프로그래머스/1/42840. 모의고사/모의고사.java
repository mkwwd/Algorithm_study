import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ansList = new ArrayList<Integer>();
   
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        int[] ans = new int[3];
        int max = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == stu1[i%stu1.length]) ans[0] ++;
            if(answers[i] == stu2[i%stu2.length]) ans[1] ++;
            if(answers[i] == stu3[i%stu3.length]) ans[2] ++;
            max = Math.max(ans[0], Math.max(ans[1], ans[2]));
        }
        
        for(int i=0; i<3; i++){
           if(ans[i] == max){
               ansList.add(i+1);
           }
        }
        
        int result[] = new int[ansList.size()];
        
        for(int i=0; i<ansList.size(); i++){
            result[i] = ansList.get(i);
        }
        
        return result;
    }
}