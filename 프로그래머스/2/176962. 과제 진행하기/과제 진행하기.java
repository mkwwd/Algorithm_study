import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        HashMap<Integer, String> subject = new HashMap<>();
        HashMap<Integer, Integer> startTime = new HashMap<>();
        HashMap<Integer, Integer> usedTime = new HashMap<>();
        Deque<Integer> list = new ArrayDeque<>();
        
        for(int i=0; i<plans.length; i++){
            list.add(i);
            String name = plans[i][0];
            String time[] = plans[i][1].split(":");
            int sTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            subject.put(i, name);
            startTime.put(i, sTime);
            usedTime.put(i, Integer.parseInt(plans[i][2]));
        }
        
        
        Deque<Integer> finish = new ArrayDeque<>();
        Deque<int[]> stop = new ArrayDeque<>();       
        
        int index = 1;
        
        while(!list.isEmpty()){
            if(list.size() == 1){
                finish.add(list.poll());
                break;
            }
      
            int now = list.poll();
            int next = list.peek();
            
            // 다음과제 시작전에 끝나는지 확인
            int gap = startTime.get(next) - (startTime.get(now) + usedTime.get(now)) ;
            if(0 <= gap){
                finish.add(now);
                // 보류중인 과제가 끝날 수 있는지 확인
                while(!stop.isEmpty()){
                    int[] stopWork = stop.pollLast();
                    if(stopWork[1] <= gap){
                        gap -= stopWork[1];
                        finish.add(stopWork[0]);
                    }else{
                        stop.add(new int[] {stopWork[0], stopWork[1] - gap});
                        break;
                    }
                }
            }else{
                // 안끝나면 보류
                // 다음시작 시간 전까지는 할 수 있음
                int done = startTime.get(next) - startTime.get(now);
                stop.add(new int[] {now, usedTime.get(now) - done});
            }
        }
        
        while(!stop.isEmpty()){
            int[] stopWork = stop.pollLast();
            finish.add(stopWork[0]);
        }
        
       
        int size = finish.size();
         String[] answer = new String[size];
        
        for(int i=0; i<size; i++){
            answer[i] = subject.get(finish.poll());
        }
        
        return answer;
    }
}