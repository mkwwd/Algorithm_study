function solution(n, t, m, p) {
    
    const len =  t*m;
    var str = "";
    var num = 0;
    
    while(str.length < len){
        str += num.toString(n);
        num++;
    }
    
    str = str.toUpperCase();
    var answer = '';
    var tube = p-1;
    
    for(let i=0; i<t; i++){
        answer += str.charAt(tube);
        tube += m;
    }
    
    return answer;
}