/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
 */
  /**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  // 方法1: 排序数组分类 -- 以排序后的字符串为key，数据项对应的key相同时，存入该key对于的list值里
  // 遍历字符串数组，将每个字符串转为list并按照字符顺序排序，再转回为字符串，
  // 此时的字符串作为key存入哈希表中，当前key不存在，则先初始化当前key对应的值为空list
  if (!strs || !strs.length) return []
  let res = []
  let map = new Map()
  for (let i = 0; i < strs.length; i++) {
    let arr = strs[i].split('')
    arr.sort()
    let strKey = arr.join('') // 目的即是得到该str做key，存哈希表
    if (!map.has(strKey)) map.set(strKey, []) // 当前key不存在，先初始化对应的值为空list
    map.get(strKey).push(strs[i])
  //   if (!map.has(strKey)){
  //     map.set(strKey, [strs[i]])
  //   } else {
  //     map.get(strKey).push(strs[i])
  //   }
  }
  map.forEach((value, key) => {
    res.push(value)
  })
  return res
};