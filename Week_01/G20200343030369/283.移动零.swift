/*
 * @lc app=leetcode.cn id=283 lang=swift
 *
 * [283] 移动零
 */

// @lc code=start

class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        //moveZeroes0(&nums)
        //moveZeroes1(&nums)
        //moveZeroes2(&nums)
        moveZeroes3(&nums)
    }

    // 自己的解
    private func moveZeroes0(_ nums: inout [Int]) {
        for index1 in stride(from: nums.count - 1, through: 0, by: -1)  where nums[index1] == 0 {
            for index2 in index1...nums.count - 1 where index2 != nums.count - 1 {
                nums.swapAt(index2, index2 + 1)
            }
        }
    }

    // 辅助数组
    private func moveZeroes1(_ nums: inout [Int]) {
        var ass: [Int] = []
        for num in nums where num != 0 {
            ass.append(num)
        }

        let zerosCount = nums.count - ass.count
        for _ in 0..<zerosCount {
            ass.append(0)
        }

        for index in 0..<nums.count {
            nums[index] = ass[index]
        }
    }

    // 双指针
    private func moveZeroes2(_ nums: inout [Int]) {
        var noneZeroNumsLastAt = 0
        for index in 0..<nums.count where nums[index] != 0 {
            nums[noneZeroNumsLastAt] = nums[index]
            noneZeroNumsLastAt += 1
        }

        for index in noneZeroNumsLastAt..<nums.count {
            nums[index] = 0
        }
    }

    // 最优解
    private func moveZeroes3(_ nums: inout [Int]) {
        var noneZeroNumsLastAt = 0
        for cur in 0..<nums.count where nums[cur] != 0 {
            nums.swapAt(noneZeroNumsLastAt, cur)
            noneZeroNumsLastAt += 1
        }
    }
}
// @lc code=end
