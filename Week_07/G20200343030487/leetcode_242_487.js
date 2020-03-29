/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false
  const res1 = {}
  const res2 = {}
  for (let i = 0, len = s.length; i < len; i++) {
      res1[s[i]] ? res1[s[i]]++ : res1[s[i]] = 1
  }
  for (let i = 0, len = t.length; i < len; i++) {
      res2[t[i]] ? res2[t[i]]++ : res2[t[i]] = 1
  }
  for (const o in res1) {
      if (res1[o] !== res2[o]) return false
  }
  
  return true
};