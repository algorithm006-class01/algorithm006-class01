// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

const findAnagrams = function (s, p) {
    let res = [];
    let left = 0,
        right = 0;
    let needs = {},
        windows = {};
    let match = 0;
    for (let i = 0; i < p.length; i++) {
        needs[p[i]] ? needs[p[i]]++ : needs[p[i]] = 1;
    }
    let needsLen = Object.keys(needs).length;
    while (right < s.length) {
        let c1 = s[right];
        if (needs[c1]) {
            windows[c1] ? windows[c1]++ : windows[c1] = 1;
            if (windows[c1] === needs[c1]) {
                match++;
            }
        }
        right++;
        while (match === needsLen) {
            if (right - left === p.length) {
                res.push(left);
            }
            let c2 = s[left];
            if (needs[c2]) {
                windows[c2]--;
                if (windows[c2] < needs[c2]) {
                    match--;
                }
            }
            left++;
        }
    }
    return res;
};