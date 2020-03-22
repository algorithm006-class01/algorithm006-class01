// https://leetcode-cn.com/problems/maximal-square/

var maximalSquare = function(matrix) {
    if (matrix.length < 1) return 0; 
    let memo = []; 
    let max = 0;
    for (let i = 0; i <= matrix.length; i++) {
        memo.push([]);
        for (let k = 0; k <= matrix[0].length; k++) {
            memo[i][k] = 0; 
        }
    }
    for (let l = 1; l <= matrix.length; l++) {
        for (let m = 1; m <= matrix[0].length; m++) {
            if (matrix[l - 1][m - 1] !== "0") {
                memo[l][m] += Math.min(memo[l - 1][m], memo[l][m - 1], memo[l - 1][m - 1]) + 1;
            }
            
            if (max < memo[l][m]) {
                max = memo[l][m];
            }
        }
    }
    return max * max;
};