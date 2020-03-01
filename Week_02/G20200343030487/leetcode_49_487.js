/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  const obj = {}
  const result = []
  for (let i = 0, len = strs.length; i < len; i++) {
      const item = strs[i].split('').sort((a, b) => {
          return a > b
      }).join('')
      if (!obj[item]) {
          obj[item] = []
      }
      obj[item].push(strs[i])
  }
  console.log(obj)
  for (const o in obj) {
      if (obj.hasOwnProperty(o)) {
          result.push(obj[o])
      }
  }
  return result
};

console.log(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
// groupAnagrams([["eat", "tea", "tan", "ate", "nat", "bat"]])