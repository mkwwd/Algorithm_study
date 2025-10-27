function solution(dirs) {
    
    var x = 0;
    var y = 0;
    
    var path = new Map();
    
    for(let i=0; i<dirs.length; i++){
        var nowx = x;
        var nowy = y;
        var dir = dirs.charAt(i);
        if(dir == 'U' && nowx < 5){
            nowx ++;
        }else if(dir == 'D' && nowx > -5){
            nowx --;
        }else if(dir == 'L' && nowy > -5){
            nowy --;
        }else if(dir == 'R' && nowy < 5){
            nowy ++;
        }
        
        if(nowx == x && nowy == y) continue;
        
        var next1 = x + " " + y + " " + nowx + " " + nowy;
        var next2 = nowx + " " + nowy + " " + x + " " + y;
       
        path.set(next1);
        path.set(next2);
        
        x = nowx;
        y = nowy;
    }
    
    var answer = 0;
    return path.size/2;
}