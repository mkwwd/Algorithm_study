function solution(answers) {
    
    var stu1 = [1, 2, 3, 4, 5];
    var stu2 = [2, 1, 2, 3, 2, 4, 2, 5];
    var stu3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    var right = Array(4).fill(0);
    
    for(let i=0; i<answers.length; i++){
        if(answers[i] == stu1[i%stu1.length]) right[1]++;
        if(answers[i] == stu2[i%stu2.length]) right[2]++;
        if(answers[i] == stu3[i%stu3.length]) right[3]++;
    }
    
    var max = Math.max(right[1], Math.max(right[2], right[3]));
    
    var answer = [];
    
    for(let i=1; i<right.length; i++){
        if(right[i] == max) answer.push(i);
    }
    
    return answer;
}