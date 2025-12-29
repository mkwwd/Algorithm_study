function solution(order) {
    
    const belt = [];
    const temp = [];
    
    for(let i=order.length; i>0; i--){
        belt.push(i);
    }
        
    var index = 0;
    
    while(index < order.length){
        
        while(belt.length && order[index] > belt[belt.length-1]){
            temp.push(belt[belt.length-1]);
            belt.pop();
        }

        if(belt.length && belt[belt.length-1] == order[index]){
            index++;
            belt.pop();
        }else if(temp.length && temp[temp.length -1] == order[index]){
            index++;
            temp.pop();
        }else break;
        
    }
    
    return index;
}