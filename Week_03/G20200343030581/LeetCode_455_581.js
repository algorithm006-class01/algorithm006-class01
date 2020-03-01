/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g = g.sort((a, b) => a - b);
    s = s.sort((a, b) => a - b);

    let i = 0,
        j = 0;
    while (i < g.length && j < s.length) {
        if (g[i] <= s[j++])
            i++;
    }
    return i;
};
