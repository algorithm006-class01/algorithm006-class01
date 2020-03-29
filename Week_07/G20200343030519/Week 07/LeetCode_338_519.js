// https://leetcode-cn.com/problems/counting-bits/

var countBits = function(num) {
  let result = [0];
  let n = 1;
  while(n <= num){
      let count = 0;
      let tmpN = n;
      while(tmpN != 0){
          count++;
          tmpN &= (tmpN-1)
      }
      result.push(count);
      n++;
  }
  return result;
};
