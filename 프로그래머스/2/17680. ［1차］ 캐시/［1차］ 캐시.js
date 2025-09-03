function solution(cacheSize, cities) {
    
    if(cacheSize == 0) return cities.length * 5;
    
    const cache = [];
    var answer = 0;
    
    for(let i=0; i<cities.length; i++){
        var now = cities[i].toLowerCase();
        if(cache.indexOf(now) >= 0){
            answer += 1;
            cache.splice(cache.indexOf(now), 1)
        }else{
            answer += 5
            if(cache.length >= cacheSize){
                cache.shift()
            }
        }
        
        cache.push(now)

    }
    
    return answer;
}