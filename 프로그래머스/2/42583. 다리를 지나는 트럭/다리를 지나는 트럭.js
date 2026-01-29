function solution(bridge_length, weight, truck_weights) {
    
    const onBridge = [];
    var index = 0;
    var time = 1;
    var total_weight = 0;
    var truckCnt = 0;
    
    for(let truck of truck_weights){
        
        if(onBridge.length && onBridge[index][1] <= time){
            total_weight -= onBridge[index][0];
            index++;
            truckCnt--;
        }
        
        while(truck + total_weight > weight || truckCnt >= bridge_length){
            total_weight -= onBridge[index][0];
            time = onBridge[index][1];
            index++;
            truckCnt--;
        }
        
        onBridge.push([truck, time+bridge_length]);
        total_weight += truck;
        truckCnt++;
        time++;
        
    }
    
    return onBridge.pop()[1];
}