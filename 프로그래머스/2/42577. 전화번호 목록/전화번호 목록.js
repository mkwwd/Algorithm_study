function solution(phone_book) {
    
    phone_book.sort();
    
    var answer = true;
    
    for(let i=1; i<phone_book.length; i++){
        var pre = phone_book[i-1];
        var now = phone_book[i];
        if(pre.length <= now.length && now.substring(0, pre.length) == pre){
            answer = false;
        }
    }
   
    return answer;
}