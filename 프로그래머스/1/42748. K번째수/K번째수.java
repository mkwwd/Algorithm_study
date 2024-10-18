import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int N = commands.length;
        int answer[] = new int[N];
        
        for(int i=0; i<N; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int size = end-start;
            int arr[] = new int[size];
            for(int j=0; j<size; j++){
                arr[j] = array[start+j];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
}