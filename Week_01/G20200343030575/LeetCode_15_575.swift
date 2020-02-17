/*
 * @lc app=leetcode.cn id=15 lang=swift
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    func threeSum(_ nums: [Int]) -> [[Int]] {
        var map = Dictionary<Int, Set<Int>>()
        for i in 0..<nums.count {
            if map[nums[i]] == nil {
                map[nums[i]] = Set<Int>()
            }
            
            map[nums[i]]!.insert(i)
        }
        var result = Set<[Int]>()
        for i in 0..<nums.count {
            for j in (i+1)..<nums.count {
                let opsiteSum = -(nums[i] + nums[j])
                if let set = map[opsiteSum], set.count > 2 || (set.contains(i) == false && set.contains(j) == false) {
                    result.insert(sortThreeNum([nums[i], nums[j], opsiteSum]))
                }
            }
        }
        return Array(result)
    }
    
    func sortThreeNum(_ nums: [Int]) -> [Int]{
        assert(nums.count == 3)
        if nums[0] <= nums[1] {
            if nums[1] <= nums[2] {
                return [nums[0], nums[1], nums[2]]
            }else if nums[0] <= nums[2] {
                return [nums[0], nums[2], nums[1]]
            }else{
                return [nums[2], nums[0], nums[1]]
            }
        }else{
            if nums[0] <= nums[2] {
                return [nums[1], nums[0], nums[2]]
            }else if nums[1] <= nums[2] {
                return [nums[1], nums[2], nums[0]]
            }else{
                return [nums[2], nums[1], nums[0]]
            }
        }
    }
}

// @lc code=end

