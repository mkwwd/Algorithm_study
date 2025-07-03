import java.util.*;

class Solution {

    static int tired[][] = {{1, 1, 1},{5, 1, 1},{25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        
        int maxBundle = Math.min((picks[0] + picks[1] + picks[2]), (minerals.length + 4) / 5);
        
        List<int[]> bundles = new ArrayList<>();
        
        for(int i = 0; i < maxBundle; i++) {
            int[] count = new int[3];
            for(int j = 0; j < 5; j++) {
                int idx = i * 5 + j;
                if(idx >= minerals.length) break;
                if(minerals[idx].equals("diamond")) count[0]++;
                else if(minerals[idx].equals("iron")) count[1]++;
                else count[2]++;
            }
            bundles.add(count);
        }
        
        // 피로도가 큰 묶음부터 정렬
        bundles.sort((o1, o2) -> {
            int score1 = o1[0] * 25 + o1[1] * 5 + o1[2];
            int score2 = o2[0] * 25 + o2[1] * 5 + o2[2];
            return score2 - score1;
        });
        
        int answer = 0;
        
        for(int[] bundle : bundles){
            int pick = -1;
            if(picks[0] > 0){
                pick = 0; picks[0]--;
            }else if(picks[1] > 0){
                pick = 1; picks[1]--;
            }else if(picks[2] > 0){
                pick = 2; picks[2]--;
            }
            
            if(pick == -1) break;
            
            answer += breakMinerals(pick, bundle);
        }
        
        return answer;
    }
    
    public int breakMinerals(int pick, int[] minerals){
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            cnt += tired[pick][i] * minerals[i];
        }
        return cnt;
    }
}
