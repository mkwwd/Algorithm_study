function solution(topping) {
    
    const chulsoo = new Map();
    const brother = new Map();
    
    for(let i=0; i<topping.length; i++){
        if(brother.has(topping[i])){
            brother.set(topping[i], brother.get(topping[i])+1);
        }else{
            brother.set(topping[i], 1);
        }
    }
    
    var answer = 0;
    
    for(let i=0; i<topping.length; i++){
        if(chulsoo.has(topping[i])){
            chulsoo.set(topping[i], chulsoo.get(topping[i])+1);
        }else{
            chulsoo.set(topping[i], 1);
        }
        if(brother.get(topping[i]) == 1){
            brother.delete(topping[i]);
        }else{
            brother.set(topping[i], brother.get(topping[i])-1);
        }
        if(chulsoo.size == brother.size) answer++;
    }
    
    
    return answer;
}