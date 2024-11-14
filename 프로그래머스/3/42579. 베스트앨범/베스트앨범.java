import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> tm = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            tm.put(genres[i], tm.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> playCnt = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        
        playCnt.addAll(tm.entrySet());
        
        int size = tm.size();
        ArrayList<Integer> music = new ArrayList<>();
        
        for(int i=0; i<size; i++){
            String gen = playCnt.poll().getKey();
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o2[0]==o1[0]) return o1[1] - o2[1];
                    return o2[0]-o1[0];
                }
            });
            
            for(int j=0; j<genres.length; j++){
                if(genres[j].equals(gen)){
                    pq.add(new int[] {plays[j], j});
                }
            }
            
            int cnt = 0;
            
            while(!pq.isEmpty() && cnt < 2){
                int max[] = pq.poll();
                music.add(max[1]);
                cnt++;
            }
            
            tm.remove(gen);
        }
        
        int answer[] = new int[music.size()]; 
        
        for(int i=0; i<music.size(); i++){
            answer[i] = music.get(i);
        }
        
        return answer;
    }
}