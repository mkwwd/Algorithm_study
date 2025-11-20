function solution(enroll, referral, seller, amount) {
    
    var name = new Map();
    var N = enroll.length;
    var parent = Array(N+1).fill(0);
    var result = Array(N).fill(0);
    
    for(let i=0; i<N; i++){
        name.set(enroll[i], i+1);
    }
    
    for(let i=0; i<N; i++){
        if(referral[i] == '-'){
            parent[i+1] = 0;
        }else{
            parent[i+1] = name.get(referral[i]);
        }
    }
    
    for(let i=0; i<seller.length; i++){
        var price = amount[i]*100;
        var node = name.get(seller[i]);
        while(node != 0){
            var minus = Math.floor(price/10);
            result[node-1] += price - minus;
            price = minus;
            node = parent[node];
        }
    }
    
    return result;
}