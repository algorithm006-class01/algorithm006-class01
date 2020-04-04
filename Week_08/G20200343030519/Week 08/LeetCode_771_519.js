// https://leetcode-cn.com/problems/jewels-and-stones/

const numJewelsInStones = function (J, S) {
    const set = new Set();
    for (const s of J) {
        set.add(s);
    }
    let ans = 0;
    for (const s of S) {
        if (set.has(s)) {
            ans++;
        }
    }
    return ans;
};