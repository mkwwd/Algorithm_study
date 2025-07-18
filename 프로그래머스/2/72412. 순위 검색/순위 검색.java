import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        
        ArrayList<ArrayList<Integer>> group = new ArrayList<>();
        
        for(int i=0; i<24; i++){
            group.add(new ArrayList<>());
        }
        
        for(int i=0; i<info.length; i++){
            String[] choose = info[i].split(" ");
            int num = 0;
            if(choose[0].equals("java")){
                num += 8;
            }else if(choose[0].equals("python")){
                num += 16;
            }
            
            if(choose[1].equals("frontend")){
                num += 4;
            }
            
            if(choose[2].equals("senior")){
                num += 2;
            }
            
            if(choose[3].equals("pizza")){
                num += 1;
            }
            
            group.get(num).add(Integer.parseInt(choose[4]));
        }
        
        for(ArrayList<Integer> num : group){
            Collections.sort(num);
        }
        
        int[] answer = new int[query.length];
        
        for(int j=0; j<query.length; j++){
            String input[] = query[j].replace("and ","").split(" ");
            Deque<Integer> que = new ArrayDeque<>();
            if(input[0].equals("cpp") || input[0].equals("-")){
                que.add(0);
            }
            if(input[0].equals("java") || input[0].equals("-")){
                que.add(8);
            }
            if(input[0].equals("python") || input[0].equals("-")){
                que.add(16);
            }
            
            int size = que.size();
            for(int i=0; i<size; i++){
                int now = que.poll();
                if(input[1].equals("backend") || input[1].equals("-")){
                    que.add(now+0);
                }
                if(input[1].equals("frontend") || input[1].equals("-")){
                    que.add(now+4);
                }
            }
            
            size = que.size();
            for(int i=0; i<size; i++){
                int now = que.poll();
                if(input[2].equals("junior") || input[2].equals("-")){
                    que.add(now+0);
                }
                if(input[2].equals("senior") || input[2].equals("-")){
                    que.add(now+2);
                }
            }
            
            size = que.size();
            
            
            
            for(int i=0; i<size; i++){
                int now = que.poll();
                if(input[3].equals("chicken") || input[3].equals("-")){
                    que.add(now+0);
                }
                if(input[3].equals("pizza") || input[3].equals("-")){
                    que.add(now+1);
                }
            }
            
            size = que.size();
            int cnt = 0;
            
            for(int i=0; i<size; i++){
                int now = que.poll();
                ArrayList<Integer> score = group.get(now);
                
                int left = 0; 
                int right = score.size();
                while(left < right){
                    int mid = (left+right)/2;
                    if(score.get(mid) < Integer.parseInt(input[4])){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                
                cnt += score.size() - left;
            }
            
            answer[j] = cnt; 
            
        }
        
        return answer;
    }
}