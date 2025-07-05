import java.util.*;

class Solution {
    public int[] solution(String s) {

        s = s.substring(2, s.length()-2);
        s = s.replace("},{","-");
        
        String[] arr = s.split("-");
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        
        ArrayList<Integer> tuple = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            String [] now = arr[i].split(",");
            for(int j=0; j<now.length; j++){
                int num = Integer.parseInt(now[j]);
                if(!tuple.contains(num)){
                    tuple.add(num);
                }
            }
        }
        
        int[] answer = new int[tuple.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = tuple.get(i);
        }
          
        return answer;
    }
}