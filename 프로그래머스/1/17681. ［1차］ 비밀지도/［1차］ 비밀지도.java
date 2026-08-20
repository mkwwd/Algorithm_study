class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for(int i=0; i<arr1.length; i++){
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);
            
            if(bin1.length() < n){
                bin1 = "0".repeat(n-bin1.length()) + bin1;
            }
            
            if(bin2.length() < n){
                bin2 = "0".repeat(n-bin2.length()) + bin2;
            }
            
            String str = "";
            
            for(int j=0; j<bin1.length(); j++){
                if(bin1.charAt(j) == '0' && bin2.charAt(j) == '0'){
                    str = str+" ";
                }else{
                    str = str+'#';
                }
            }
            
            answer[i] = str;
            
        }
        
        return answer;
    }
}