// https://leetcode-cn.com/problems/combinations/

var combine = function(n, k) {
    var result = [];
    var subresult = [];
    if (n == k || k == 0) {
        var tmp = [];
        for (var i = 1; i <= k; i++) {
            subresult.push(i);
        }
        tmp.push(subresult);
        return tmp;
    }
    var result = combine(n-1, k-1);
    result.map((arr) => arr.push(n));
    var tmp = combine(n-1, k);
    tmp.map((arr) => result.push(arr));
    return result;
};