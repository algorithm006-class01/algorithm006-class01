/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
// 解法1：
// 1. intervals的每个子数组根据其第一个元素进行排序，得到连通块；
// 2. 遍历连通块，将连通块的最小区间left跟合并列表的最右区间right对比
//      a. left[0] <= right[1]，则进行合并，right.end = max(right.end, left.end)
//      b. 否则直接将区间加入合并列表；
var merge1 = function (intervals) {
    intervals.sort((a, b) => a[0] - b[0])
    const merged = []
    for (const left of intervals) {
        const mergedLast = merged[merged.length - 1]
        if (!merged.length || mergedLast[1] < left[0]) {
            merged.push(left)
        } else {
            mergedLast[1] = Math.max(left[1], mergedLast[1])
        }
    }
    return merged
};

// 解法2：
// 在解法1基础上，使用双指针对数组进行原地操作，减少了merged的空间消耗
var merge = function (intervals) {
    intervals.sort((a, b) => a[0] - b[0])
    let p = 0 // 记录合并数组的最大索引
    for (let i = 0; i < intervals.length; i++) {
        if (intervals[p][1] >= intervals[i][0]) {
            intervals[p][1] = Math.max(intervals[i][1], intervals[p][1])
        } else {
            intervals[++p] = intervals[i]
        }
    }
    return intervals.slice(0, p + 1)
};