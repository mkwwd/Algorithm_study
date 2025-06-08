function solution(phone_book) {
    
    phone_book.sort();
    
    var answer = true;
    
    for(let i=1; i<phone_book.length; i++){
        let pre = phone_book[i-1];
        let number = phone_book[i];
        if(pre.length <= number.length && number.substring(0, pre.length) == pre){
            answer = false;
            break
        }
    }

    return answer;
}