function solution(sizes) {
    
    var maxW = 0;
    var maxH = 0;
    
    for(let i=0; i<sizes.length; i++){
        var max = Math.max(sizes[i][0], sizes[i][1]);
        var min = Math.min(sizes[i][0], sizes[i][1]);
        maxW = Math.max(max, maxW);
        maxH = Math.max(min, maxH);
    }
    
    return maxW*maxH;
}