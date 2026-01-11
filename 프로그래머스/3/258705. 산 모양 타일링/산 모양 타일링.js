function solution(n, tops) {
    
    var green = tops[0] == 0? 2 : 3;
    var purple = 1;
    
    for(let i=1; i<n; i++){
        var nextGreen = tops[i] == 0? 2*green + purple : 3*green + 2*purple;
        var nextPurple = green + purple;
        
        green = nextGreen%10007;
        purple = nextPurple%10007;
    }
    
    return (green+purple)%10007;
}