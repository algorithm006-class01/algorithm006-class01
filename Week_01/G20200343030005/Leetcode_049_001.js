/**
49. 字母异位词分组


解法一：常规解法


解法二
我们将每个字符串按照字母顺序排序，这样的话就可以把 eat，tea，ate 都映射到 aet。其他的类似。

*/

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function(strs) {
  var strMap = new Map();
  for (var str of strs) {
    var chars = [...str];
    chars.sort();
    var key = chars.join("");
    if (!strMap.has(key)) {
      strMap.set(key, []);
    }
    strMap.get(key).push(str);
  }
  console.log(strMap);
  var sArr = [];
  for (let value of strMap.values()) {
    console.log(value);
    sArr.push(value);
  }
  console.log(sArr);
  return sArr;
  return [...strMap.values()];
};
console.log(groupAnagrams(arr));

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function(strs) {
  var hashMap = new Map();
  for (var str of strs) {
    var chars = [...str];
    chars.sort();
    var key = chars.join("");
    if (!hashMap.has(key)) {
      hashMap.set(key, [str]);
    } else {
      hashMap.get(key).push(str);
    }
  }
  console.log(hashMap);
  var arr = [];
  for (let value of hashMap.values()) {
    // console.log(value);
    arr.push(value);
  }
  console.log(arr);
  return arr;
};

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function(strs) {
  var hashMap = new Map();
  for (var str of strs) {
    var key = [...str].sort().join("");
    if (hashMap.has(key)) {
      hashMap.get(key).push(str);
    } else {
      hashMap.set(key, [str]);
    }
  }
  console.log(hashMap);
  return [...hashMap.values()];
};

/**

解法三
算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。

利用这个，我们把每个字符串都映射到一个正数上。

用一个数组存储质数 prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}。

然后每个字符串的字符减去 ' a ' ，然后取到 prime 中对应的质数。把它们累乘。

例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，即 0, 1, 2，也就是对应素数 2 3 5，然后相乘 2 * 3 * 5 = 30，就把 "abc" 映射到了 30。


作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/

*/
/**
//26个字母的质数对应表
        int char_hash[26] = {
            2,  3,  5,  7,  11, 
            13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 
            53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 
            101 
        } ;

作者：xu-zhou-geng
链接：https://leetcode-cn.com/problems/group-anagrams/solution/cpp-24mszhi-shu-de-miao-yong-1-by-xu-zhou-geng/


*/

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function(strs) {
  var hashMap = new Map();
  //每个字母对应一个质数
  var sprime =
    "2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101";
  //    29, 31, 41,

  var prime = sprime.split(",");

  console.log("质数:", prime.length);
  var A_ASCII = 97;
  for (var str of strs) {
    var hash = 1;
    for (var i = 0; i < str.length; i++) {
      //   console.log("index:", str.charCodeAt(i) - A_ASCII);
      hash *= prime[str.charCodeAt(i) - A_ASCII];
    }
    console.log("hash:", hash);

    if (!hashMap.has(hash)) {
      hashMap.set(hash, [str]);
    }
    hashMap.get(hash).push(str);
  }
  console.log(hashMap);
  return [...hashMap.values()];
};
console.log(groupAnagrams(arr));

/**
解法四
首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。

这样的话，"abb" 就映射到了 "1#2#0#0#0"。

"cdc" 就映射到了 "0#0#2#1#0"。

"dcc" 就映射到了 "0#0#2#1#0"。

作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/


 */

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function(strs) {
  var hashMap = new Map();
  var A_ASCII = 97;
  var SIZE = 26;
  for (let i = 0; i < strs.length; i++) {
    var str = strs[i];
    var arr = new Array(SIZE).fill(0); //size:26
    for (var j = 0; j < str.length; j++) {
      arr[str.charCodeAt(j) - A_ASCII]++;
    }
    //转成 0#2#2# 类似的形式
    var key = "";
    for (var j = 0; j < SIZE; j++) {
      key += arr[j] + "#";
    }
    console.log("------------------");
    console.log("arr:", arr);
    console.log("key:", key);

    if (hashMap.has(key)) {
      hashMap.get(key).push(str);
    } else {
      hashMap.set(key, [str]);
    }
  }
  console.log("-------hashMap:-----------");
  console.log("hashMap:", hashMap);

  return [...hashMap.values()];
};
