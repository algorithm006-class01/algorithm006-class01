/**
242. 有效的字母异位词

字符替换
*/
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  for (var char of t) {
    if (s.includes(char)) {
      s = s.replace(char, "");
    }
  }
  return !s; //s == ""
};
/**
排序sort
*/
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;

  var arr1 = [...s];
  var arr2 = [...t];
  arr1.sort();
  arr2.sort();

  return arr1.join("") == arr2.join("");
};

/**
哈希表 统计的方法：

算法：


为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var A_ASCII = "a".charCodeAt(); //97
  //   var Z_ASCII = "z".charCodeAt();
  var arr = []; //size:26
  arr.length = 26;
  arr.fill(0);
  for (var i = 0; i < s.length; i++) {
    //   [ 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 ]
    arr[s.charCodeAt(i) - A_ASCII]++;
    // [ -3, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0 ]
    arr[t.charCodeAt(i) - A_ASCII]--;
  }
  console.log(arr);
  for (var value of arr) {
    if (value !== 0) return false;
  }
  return true;
};

var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var map = {};
  for (let i = 0; i < s.length; i++) {
    map[s[i]] = (map[s[i]] || 0) + 1;
    map[t[i]] = (map[t[i]] || 0) - 1;
  }
  console.log(map);
  for (var key in map) {
    if (map[key] !== 0) return false;
  }
  return true;
};

/**
错误题解：

var isAnagram = function(s, t) {  
  if (s.length !== t.length) return false;  
  var n = 0;  
  for (var i = 0; i < s.length; i++) {  
    n += s.charCodeAt(i);  
    n -= t.charCodeAt(i);  
  }  
  return !n;  
};  

输入："ac" "bb"
输出：true
预期：false

*/

var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var A_ASCII = "a".charCodeAt(); //97
  //   var Z_ASCII = "z".charCodeAt();
  var arr = []; //size:26
  arr.length = 26;
  arr.fill(0);
  for (var i = 0; i < s.length; i++) {
    //[ 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 ]
    arr[s.charCodeAt(i) - A_ASCII]++;
  }
  for (var i = 0; i < t.length; i++) {
    var index = t.charCodeAt(i) - A_ASCII;
    if (--arr[index] < 0) {
      return false;
    }
  }
  return true;
};

var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var json = {};
  for (var i = 0; i < s.length; i++) {
    var name = s[i];
    if (json[name]) {
      json[name]++;
    } else {
      json[name] = 1;
    }
  }
  for (var i = 0; i < t.length; i++) {
    var name = t[i];
    if (!json[name]) return false;
    if (--json[name] < 0) return false;
  }
  return true;
};

var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var map = {};
  for (var char of s) {
    if (char in map) {
      map[char]++;
    } else {
      map[char] = 1;
    }
  }
  for (var char of t) {
    if (char in map && map[char] > 0) {
      map[char]--;
    } else {
      return false;
    }
  }
  return true;
};

var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  var map = new Map();
  for (var char of s) {
    if (map.has(char)) {
      var n = map.get(char);
      map.set(char, ++n);
    } else {
      map.set(char, 1);
    }
  }
  for (var char of t) {
    if (map.has(char) && map.get(char) > 0) {
      var n = map.get(char);
      map.set(char, --n);
    } else {
      return false;
    }
  }
  return true;
};
