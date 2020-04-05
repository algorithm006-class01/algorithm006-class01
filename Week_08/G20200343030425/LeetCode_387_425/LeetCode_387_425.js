/*
* address: https://leetcode-cn.com/problems/unique-paths-ii/
* */

var firstUniqChar = function(s) {
    let num = 0;
    while(num<s.length){
        let startIndex = s.indexOf(s[num]);
        let endIndex = s.lastIndexOf(s[num]);
        if(endIndex === startIndex){
            return num;
        }
        num++;
    }
    return -1;
};
