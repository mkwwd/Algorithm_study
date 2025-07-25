import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int index = col-1;
        
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                if(o1[index] == o2[index]){
                    return o2[0]-o1[0];
                }else{
                    return o1[index] - o2[index];
                }
            }
        });
        
        int answer = 0;
        
        for(int i=row_begin-1; i<row_end; i++){
            int sum = 0;
            for(int num : data[i]){
                sum += num % (i+1);
            }
            answer = (answer^sum);
        }

        return answer;
    }
}