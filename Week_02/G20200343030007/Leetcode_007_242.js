/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * 1. 暴力法
 *
 */
var isAnagram = function(s, t) {
    // 将字符串转为数组
    const sortedStr1 = Array.from(s);
    const sortedStr2 = Array.from(t);

    // 将数组 sort
    const a = sortedStr1.sort();
    const b = sortedStr2.sort();
    return a == b;
};

var isAnagram = function(s, t) {
    return s.split('').sort().join('') === t.split('').sort().join('');
};


const s = 'anagram', t = 'nagaram';
const result = isAnagram(s, t);
console.log(result);


/**
 * 解题四件套
 * 1. 和面试官问清楚题目
 * 2. 想出所有的解法，找出复杂度最低的最优解
 * 3. 开始编写
 * 4. 写测试样例
 *
 *
 * 解法：
 * 1. 暴力法，sort 后判断字符串是否相同
 * 2. hash，map 统计每个字母出现的频次
 */