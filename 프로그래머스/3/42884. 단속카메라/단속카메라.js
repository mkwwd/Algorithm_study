function solution(routes) {
    
    routes.sort((a, b) => {
        if(a[1] == b[1]){
            return a[0] - b[0]
        }else return a[1] - b[1]
    })
    
    var cctv = routes[0][1];
    var cnt = 1;
    
    for(let i=0; i<routes.length; i++){
        if(routes[i][0] <= cctv && cctv <= routes[i][1]) continue
        cnt++
        cctv = routes[i][1]
    }
    
    return cnt;
}