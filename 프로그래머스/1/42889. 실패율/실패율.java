import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int round[] = new int[N+2];
        
        for(int i=0; i<stages.length; i++){
            round[stages[i]]++;
        }
        
        int player = stages.length;
        
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2){
                if(Double.compare(o2[0], o1[0]) == 0){
                    return Double.compare(o1[1], o2[1]);
                }
                return Double.compare(o2[0], o1[0]);
            }
        });
        
        for(int i=1; i<N+1; i++){
            double percent = 0.0;
            if(player > 0){
                percent = (double)round[i]/player;
                player -= round[i];
            }else{
                percent = 0.0;
            }
            pq.add(new double[]{percent, i});
        }
        
        int[] answer = new int[N];
        
        for(int i=0; i<N; i++){
            double num[] = pq.poll();
            answer[i] = (int)num[1];
        }
        
        return answer;
        
    }
}