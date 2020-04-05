// 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/

// 解法一：哈希 + Map
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let hash = {};
  let result = new Map();
  for (let i = 0; i < s.length; i++) {
    if (!hash[s[i]]) {
      hash[s[i]] = 1;
      result.set(s[i], i);
    } else {
      result.delete(s[i]);
    }
  }
  if (result.size == 0) {
    return -1;
  }
  return result.values().next().value;
};
// 解法二：哈希 + 遍历
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let hash = {};
  let result = [];
  for (let i = 0; i < s.length; i++) {
    if (!hash[s[i]]) {
      hash[s[i]] = 1;
    } else {
      hash[s[i]]++;
    }
  }
  for (let j = 0; j < s.length; j++) {
    if (hash[s[j]] == 1) {
      return j;
    }
  }
  return -1;
};

// 解法三：库函数
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  for (let i = 0; i < s.length; i++) {
    if (s.indexOf(s[i]) === s.lastIndexOf(s[i])) {
      return i;
    }
  }
  return -1;
};

// 解法四：计数排序
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let countingSort = (arr, maxValue) => {
    let bucket = new Array(maxValue).fill(0);
    let arrLen = arr.length;
    for (let i = 0; i < arrLen; i++) {
      bucket[arr[i].charCodeAt() - 97]++;
    }
    for (let j = 0; j < arrLen; j++) {
      if (bucket[arr[j].charCodeAt() - 97] == 1) {
        return j;
      }
    }
    return -1;
  };
  return countingSort(s, 26);
};
