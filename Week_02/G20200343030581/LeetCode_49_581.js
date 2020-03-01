/**
 * @param {string[]} strs
 * @return {string[][]}
 */
// 1. HashMap 排序后的字符串作为健值
var groupAnagrams = function(strs) {
    let map = new Map();
    for (let s of strs) {
        let sortedStr = s.split('').sort().join('');
        if (map.has(sortedStr)) {
            map.get(sortedStr).push(s);
        } else {
            map.set(sortedStr, [s]);
        }
    }
    return [...map.values()];
};

// 2.HasMap 统计字符出现次数作为健值
var groupAnagrams = function(strs) {
    let map = new Map();
    let a = 'a'.charCodeAt(0);
    for (let s of strs) {
        
        let arr = Array(26).fill(0);
        for (let i = 0; i < s.length; i++)
            arr[s.charCodeAt(i) - a]++;

        let keyStr = arr.join(',');
        if (map.has(keyStr))
            map.get(keyStr).push(s);
        else
            map.set(keyStr, [s]);
    }

    return [...map.values()];
}
