class Solution {
    public String solution(int[] food) {
        
        String list = "";
        
        for(int i=1; i<food.length; i++){
            int div = food[i]/2;
            String str = Integer.toString(i);
            list = list+str.repeat(div);
        }
        
        StringBuilder sb = new StringBuilder(list);
        
        String answer = list + "0" +sb.reverse().toString();
        
        return answer;
    }
}