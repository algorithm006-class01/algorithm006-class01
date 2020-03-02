//
//  0154_FindMinimumInRotatedSortedArrayII.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
//  Created by Ryeagler on 2020/3/1.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class FindMinimumInRotatedSortedArrayII {
    func findMin(_ nums: [Int]) -> Int {
        var left = 0, right = nums.count - 1
        while left < right {
            let mid = (left + right) / 2
            if nums[mid] > nums[right] {
                left = mid + 1
            } else if nums[mid] < nums[right] {
                right = mid - 1
            } else {
                right -= 1
            }
        }
        return -1
    }
}
