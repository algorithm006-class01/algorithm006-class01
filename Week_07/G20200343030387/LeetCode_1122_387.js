/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
// 计数排序：
// 1. 统计arr1的元素个数，放入另外一个数组bucket中，其索引为arr1的元素值
// 2. 遍历arr2，根据元素值找到bucket的数量值，填上相应数量的元素
// 3. 遍历bucket，输出还有数量值的元素
var relativeSortArray = function (arr1, arr2) {
    const bucket = new Array(1001).fill(0)
    for (const v of arr1) {
        bucket[v]++
    }
    const res = []
    for (const v of arr2) {
        res.push(...(new Array(bucket[v]).fill(v)))
        bucket[v] = 0
    }
    for (let v = 0; v < bucket.length; v++) {
        res.push(...(new Array(bucket[v]).fill(v)))
    }
    return res
};