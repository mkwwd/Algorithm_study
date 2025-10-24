import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        int x = 0;
        int y = 0;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            int nowx = x, nowy = y;
            char now = dirs.charAt(i);
            switch(now){
                case 'U' : 
                    if(x < 5) x++;
                    break;
                case 'D' :
                    if(x > -5) x--;
                    break;
                case 'L' :
                    if(y > -5) y--;
                    break;
                case 'R' :
                    if(y < 5) y++;
                    break;
            }
            
            if (nowx == x && nowy == y) continue;
            String path1 = x + " " + y + "->" + nowx + " " + nowy;
            String path2 = nowx + " " + nowy + "->" + x + " " + y;
            
            set.add(path1);
            set.add(path2);
        }

        return set.size()/2;
    }
}