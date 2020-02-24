/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 1.排序
var isAnagram = function(s, t) {
    return s.split('').sort().join('') == t.split('').sort().join('');
};

// 2.HashMap O(n)
var isAnagram = function(s, t) {
    if (s.length != t.length)
        return false;
    let a = 'a'.charCodeAt(0);
    let map = Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        map[s.charCodeAt(i) - a]++;
        map[t.charCodeAt(i) - a]--;
    }
    return map.every(e => e == 0);
}

// 3.HashMap优化，发现一个字符不符合条件就返回False
var isAnagram = function(s, t) {
    if (s.length != t.length)
        return false;
    let a = 'a'.charCodeAt(0);
    let map = Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        map[s.charCodeAt(i) - a]++;
    }
    for (let i = 0; i < t.length; i++) {
        let tmp = t.charCodeAt(i) - a;
        if (map[tmp] <= 0)
            return false;
        map[tmp]--;
    }

    return true;
}
