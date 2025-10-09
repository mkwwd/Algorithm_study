function solution(queue1, queue2) {
    
    var sum1 = queue1.reduce((a,b) => a+b);
    var sum2 = queue2.reduce((a,b) => a+b);
    
    if(sum1 == sum2) return 0;
    
    const total = sum1 + sum2;
    if (total % 2 !== 0) return -1; 
    
    const target = total/2;
    const arr = [...queue1, ...queue2];
    
    let i = 0;
    let j = queue1.length;
    let cnt = 0;
    let size = queue1.length*3;
    
    while(cnt <= size){
        
        if (sum1 === target) return cnt;
        
        if(sum1 > target){
            sum1 -= arr[i];
            i++;
        }else{
            sum1 += arr[j];
            j++;
        }
        
        cnt++;
    }

    return -1;
}