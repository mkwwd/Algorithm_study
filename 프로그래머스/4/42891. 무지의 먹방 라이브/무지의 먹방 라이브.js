function solution(food_times, k) {
    
    var n = food_times.length;
    const list = [];
    
    for(let i=0; i<n; i++){
        list.push([food_times[i], i+1]);
    }
    
    list.sort((a,b) => a[0]-b[0]);
    
    var prev = 0;
    var remain = n;
    
    for(let i=0; i<n; i++){
        let now = list[i][0];
        let diff = now-prev;
        if(diff != 0){
            let del = diff*remain;
            if(k >= del){
                k -= del;
                prev = now;
            }else{
                const rest = list.slice(i);
                rest.sort((a,b) => a[1]-b[1]);
                return rest[k%remain][1];
            }
        }
        remain --;
    }
    return -1;
}