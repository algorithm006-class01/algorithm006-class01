// https://leetcode-cn.com/problems/group-anagrams/

var groupAnagrams = function(strs) {
    let hash = new Map();
    for (let i = 0; i < strs.length; i++) {
        let str = strs[i].split('').sort().join();
        if (hash.has(str)) {
            let temp = hash.get(str);
            temp.push(strs[i]);
            hash.set(str, temp)
        } else {
            hash.set(str, [strs[i]]);
        }
    }
    return [...hash.values()]
};