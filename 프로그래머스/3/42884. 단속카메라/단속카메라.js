function solution(routes) {
    
    var answer = 0;
    
    routes.sort((a, b) => a[1] - b[1]);
    
    var end = -50000;
    
    for(let i=0; i<routes.length; i++){
        if(end < routes[i][0]){
            end = routes[i][1];
            answer++;
        }
    }
    
    return answer;
}