function solution(topping) {
    
    var cnt = 0;
    
    var mapA = new Map()
    var mapB = new Map()
    
    for(let i=0; i<topping.length; i++){
        if(mapB.get(topping[i]) > 0){
            mapB.set(topping[i], mapB.get(topping[i])+1)
        }else{
            mapB.set(topping[i], 1)
        }
    }
    
    for(let i=0; i<topping.length; i++){
        if(mapA.get(topping[i]) > 0){
            mapA.set(topping[i], mapA.get(topping[i])+1)
        }else{
            mapA.set(topping[i], 1)
        }
        
        let out = mapB.get(topping[i])
        if(out == 1){
            mapB.delete(topping[i])
        }else{
            mapB.set(topping[i], out-1)
        }
        
        if(mapA.size == mapB.size) cnt++
    }
    
    
    return cnt
}