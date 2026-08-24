class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int col = arr1.length;
        int row = arr1[1].length;
        
        int[][] answer = new int[col][row];
        
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}