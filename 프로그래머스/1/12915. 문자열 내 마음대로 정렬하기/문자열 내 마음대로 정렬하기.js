function solution(strings, n) {
    
    strings.sort((a,b) => {
        if(a.charAt(n) == b.charAt(n)){
            return a.localeCompare(b);
        }
        return a[n].localeCompare(b[n]);
    })
    
    return strings;
}