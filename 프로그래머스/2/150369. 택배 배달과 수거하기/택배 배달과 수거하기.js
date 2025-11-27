function solution(cap, n, deliveries, pickups) {
    
    const delivery = [];
    const pickup = [];
    
    for(let i=0; i<n; i++){
        delivery.push(deliveries[i]);
        pickup.push(pickups[i]);
    }
    
    var answer = 0;
    
    while(delivery.length || pickup.length){
        while(delivery.length && delivery[delivery.length-1] == 0){
            delivery.pop();
        }
        while(pickup.length && pickup[pickup.length-1] == 0){
            pickup.pop();
        }
        
        let max = Math.max(delivery.length, pickup.length);
        answer += max*2;
        
        let del = cap;
        let pic = cap;
        
        while(del > 0 && delivery.length){
            var pop = delivery.pop();
            if(pop > del){
                delivery.push(pop - del);
            }
            del -= pop;
        }
        
        while(pic > 0 && pickup.length){
            var pop = pickup.pop();
            if(pop > pic){
                pickup.push(pop - pic);
            }
            pic -= pop;
        }
        
    }
    

    return answer;
}