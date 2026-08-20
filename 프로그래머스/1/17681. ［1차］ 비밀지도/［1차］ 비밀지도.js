function solution(n, arr1, arr2) {
    
    var answer = [];
    
    for(let i=0; i<arr1.length; i++){
        var bin1 = arr1[i].toString(2);
        var bin2 = arr2[i].toString(2);
        
        if(bin1.length < n){
            bin1 = "0".repeat(n-bin1.length) + bin1;
        }
        
        if(bin2.length < n){
            bin2 = "0".repeat(n-bin2.length) + bin2;
        }
        
        var str = "";
        
        for(let j=0; j<bin1.length; j++){
            if(bin1.charAt(j) == 0 && bin2.charAt(j) == 0){
                str += " ";
            }else{
                str += "#";
            }
        }
        
        answer.push(str);
        
    }
    
    return answer;
}