/**
 * @param {number[]} height
 * @return {number}
 */
// 1.暴力
// var trap = function(height) {
//     let res = 0;
//     for(let k = 0; k < height.length; k++) {
//         let maxLeftHeight = 0, maxRightHeight = 0;
//         for (let i = 0; i <= k; ++i)
//             maxLeftHeight = Math.max(maxLeftHeight, height[i]);
//         for (let j = k; j < height.length; ++j)
//             maxRightHeight = Math.max(maxRightHeight, height[j]);
//         
//         res += Math.min(maxLeftHeight, maxRightHeight) - height[k];
//     }
// 
//     return res;
// };
// 2. 单调栈
var trap = function (height) {
    let res = 0;
    let stack = [];
    const peek = () => stack[stack.length - 1];
    for (let i = 0; i < height.length; i++) {
        while (stack.length > 0 && height[i] > height[peek()]) {
            let top = stack.pop();
            if (!stack.length) break;
            let w = i - peek() - 1;
            let h = Math.min(height[peek()], height[i]) - height[top];
            res += w * h;
        }

        stack.push(i);
    }

    return res;
}
