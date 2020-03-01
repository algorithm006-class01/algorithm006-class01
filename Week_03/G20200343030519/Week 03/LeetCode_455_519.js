// https://leetcode-cn.com/problems/assign-cookies/description/

var findContentChildren = function(g, s) {
    g.sort((a, b) => b - a);
    s.sort((a, b) => b - a);
    let gi = 0; // 胃口值
    let sj = 0; // 饼干尺寸
    let res = 0;
    while (gi < g.length && sj < s.length) {
        // 如果sj大于gi 我们可以将这个饼干j分配给孩子i 孩子会满足
        if (s[sj] >= g[gi]) {
            gi++;
            sj++;
            res++;
        } else {
            gi++;
        }
    }
    return res;
};