function solution(a, b, g, s, w, t) {
    
    var start = 0;
    var end = 10e9 * 2 * 10e5 * 2;    
    var answer = 0;
    
    while(start <= end){
        var mid = Math.floor((start+end)/2);
        var sumTotal = 0;
        var sumGold = 0;
        var sumSilver = 0;
        for(let i=0; i<t.length; i++){
            var cnt = Math.round(mid/(t[i]*2))
            var weight = w[i]*cnt;
            sumTotal += Math.min(g[i] + s[i], weight);
            sumGold += Math.min(g[i], weight);
            sumSilver += Math.min(s[i], weight);
        }
        
        if(a <= sumGold && b <= sumSilver && a + b <= sumTotal){
            answer = mid;
            end = mid-1;
        }else{
            start = mid+1;
        }
    }
    
    return answer;
}