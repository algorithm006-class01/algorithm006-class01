let firstUniqChar = function(s) {
  const strObj = {};
  for (let i = 0; i < s.length; i++) {
    if (!strObj[s[i]]) {
      strObj[s[i]] = 1;
    } else {
      strObj[s[i]] += 1;
    }
  }
  for (let i = 0; i < s.length; i++) {
    if (strObj[s[i]] === 1) {
      return i;
    }
  }
  return -1;
};
