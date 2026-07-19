function solution(food) {
    
    var list = "";
    
    for(let i=1; i<food.length; i++){
        var div = food[i]/2;
        var str = String(i);
        list += str.repeat(div);
    }
    
    var answer = list + "0"+ [...list].reverse().join("");
    
    return answer;
}