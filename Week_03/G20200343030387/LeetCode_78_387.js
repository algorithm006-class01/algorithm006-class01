/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// 递归法
// n（nums长度）个格子里放数值，可放可不放
var subsets = function (nums) {
    const res = []
    const recursion = function (level, max, list) {
        // terminator
        if (level >= max) {
            res.push(list)
            return
        }

        // process current logic 
        // drill down 
        recursion(level + 1, max, list.slice(0))
        list.push(nums[level])
        recursion(level + 1, max, list.slice(0))

        // restore current status 
    }
    recursion(0, nums.length, [])
    return res
};
