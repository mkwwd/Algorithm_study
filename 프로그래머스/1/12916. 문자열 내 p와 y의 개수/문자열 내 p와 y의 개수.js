function solution(s){
    
    var nop = s.replaceAll("p","").replaceAll("P","");
    var noy = s.replaceAll("y","").replaceAll("Y","");
    
    var answer = true;
    if(nop.length != noy.length) answer = false;

    return answer;
}