import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        StringTokenizer st;
        
        TreeMap<Integer, Integer> cars = new TreeMap<>();
        TreeMap<Integer, Integer> times = new TreeMap<>();
        
        for(int i=0; i<records.length; i++){
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if(type.equals("IN")){
                String input[] = time.split(":");
                int inTime = Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);
                System.out.println(inTime);
                cars.put(carNum, inTime);
            }else{
                String input[] = time.split(":");
                int outTime = Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);
                int inTime = cars.get(carNum);
                int parkTime = outTime - inTime;
                times.put(carNum, times.getOrDefault(carNum, 0) + parkTime);
                System.out.println("parkTime" + parkTime);
                cars.remove(carNum);
            }
            
        }

        for(Map.Entry <Integer, Integer> noOut : cars.entrySet()){
            int carNum = noOut.getKey();
            int time = noOut.getValue();
            int parkTime = 23*60 + 59 - time;
            times.put(carNum, times.getOrDefault(carNum, 0) + parkTime);
        }
            
        int answer[] = new int[times.size()];
        int index = 0;
        
        for(Map.Entry<Integer, Integer> parkTime : times.entrySet()){
            int time = parkTime.getValue();
            int overTime = time - fees[0];
            if(overTime <=0){
                answer[index++] = fees[1];
            }else{
                answer[index++] = fees[1] + (int)Math.ceil((double)overTime/fees[2]) * fees[3];
            }
        }
        
        
        return answer;
    }
}