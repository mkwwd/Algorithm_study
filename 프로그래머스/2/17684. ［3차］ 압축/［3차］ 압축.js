function solution(msg) {
    
    const word = ["", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L","M","N","O","P","Q","R","S","T","U","V","W","X", "Y", "Z"]
    
    let len = msg.length;
    
    const answer = [];
    
    for(let i=0; i<len;){
        var plus = 1;
        
        while(i+plus <= len && word.includes(msg.substring(i, i+plus))){
            plus++;
        }
        
        var cut = msg.substring(i, i+plus-1);
        answer.push(word.indexOf(cut));
        
        if(i+plus-1 < len){
            word.push(cut + msg.charAt(i+plus-1));
        }
        
        i += plus -1;
        
    }

    return answer;
}