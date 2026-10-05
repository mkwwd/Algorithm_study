import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
   
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] right = new int [4];
       
        for(int i=0; i<answers.length; i++){
            if(answers[i] == stu1[i%stu1.length]) right[1]++;
            if(answers[i] == stu2[i%stu2.length]) right[2]++;
            if(answers[i] == stu3[i%stu3.length]) right[3]++;
        }
        
        int max = Math.max(right[1], Math.max(right[2], right[3]));
        
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i=1; i<4; i++){
            if(right[i]==max) que.add(i);
        }
        
        int size = que.size();
        int result[] = new int[size];
        
        for(int i=0; i<size; i++){
            result[i] = que.poll();
        }
        
        return result;
    }
}