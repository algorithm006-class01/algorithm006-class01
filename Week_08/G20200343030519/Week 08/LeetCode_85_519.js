// https://leetcode-cn.com/problems/maximal-rectangle/

const maximalRectangle = function (matrix) {
    if (!matrix || matrix.length == 0) {
        return 0;
    }
    let largestRectangleArea = function (heights) {
        let stack = [-1];
        for (let i = 0; i < heights.length; i++) {
            while (stack.length > 1 && heights[stack[stack.length - 1]] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack[stack.length - 1] - 1));
            }
            stack.push(i);
        }
        while (stack.length > 1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack[stack.length - 1] - 1));
        }
    };
    let row = matrix.length;
    let col = matrix[0].length;
    let maxarea = 0;
    let heights = new Array(col).fill(0);
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (matrix[i][j] == '1') {
                heights[j] += 1;
            } else {
                heights[j] = 0;
            }
        }
        largestRectangleArea(heights);
    }
    return maxarea;
};