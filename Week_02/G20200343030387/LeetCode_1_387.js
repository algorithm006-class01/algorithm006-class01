/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 暴力法
// 时间复杂度：O(n^2)
var twoSum1 = function(nums, target) {
    const size = nums.length
    for (let i = 0; i < size; i++) {
        for (let j = i + 1; j < size; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j]
            }
        }
    }
    return []
}

// 两遍哈希法
// 先循环一遍数组构造hash表，再循环一遍数组进行判断
// 时间复杂度：O(2n)
var twoSum2 = function(nums, target) {
    const size = nums.length
    const hash = {}
    for (let i = 0; i < size; i++) {
        hash[nums[i]] = i
    }
    let j
    for (i = 0; i < size; i++) {
        j = hash[target - nums[i]]
        if (Number.isInteger(j) && i !== j) {
            return [i, j]
        }
    }
    return []
}

// 一遍哈希法
// 遍历一次数组进行判断，同时构造hash表，因为前面构建完成在后面也会被用来判断
// 时间复杂度：O(n)
var twoSum = function(nums, target) {
    const hash = {}
    let j
    for (let i = 0; i < nums.length; i++) {
        j = hash[target - nums[i]]
        if (Number.isInteger(j) && i !== j) {
            return [i, j]
        }
        if (!Number.isInteger(hash[nums[i]])) {
            hash[nums[i]] = i
        }
    }
    return []
}
