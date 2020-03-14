// https://leetcode-cn.com/problems/palindromic-substrings/

function countSubstrings(s) {
    let total = 0;
    for (let i = 0; i < s.length; i++) {
      total += expand(s, i, i);
      total += expand(s, i, i + 1);
    }
    return total;
  };
  
  function expand(s, l, r) {
    let count = 0;
    while (l >= 0 && r < s.length && s[l] === s[r]) {
      l--;
      r++;
      count++;
    }
    return count;
  }