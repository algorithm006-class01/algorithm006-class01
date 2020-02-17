/**
 * @param {number[]} height
 * @return {number}
 * 盛水最多的容器
 * 双指针法
 */
var maxArea = function(height) {
    let maxArea = 0;

    for (let i = 0, j = height.length - 1; i < j;) {
        const minHeight = height[i] < height[j] ? height[i++] : height[j--];
        const area = (j - i + 1) * minHeight;
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
};



/**
 * 双指针紧逼法
 * 原理：最大盛水面积取决于短边的长度
 * 指针1：最左边
 * 指针2：最右边
 * 如果左指针高度 < 右指针高度，左边往里缩，反之亦然
 */