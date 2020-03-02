// https://leetcode-cn.com/problems/powx-n/

var myPow = function(x, n) {
    if (n == 0) {
        return 1;
    }
    x = parseFloat(x);
    if (n < 0) {
        x = parseFloat(1/x);
        n = -n;
    }
    var subresult = x;
    var result = 1;
    for (var i = n; i > 0; i = parseInt(i/2)) {
        if (i&1 == 1) {
            result = result * subresult;
        }
        subresult = subresult * subresult;
    }
    return result;
};