//
//  0033_SearchInRotatedSortedArray.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
//  Created by Ryeagler on 2020/3/1.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class SearchInRotatedSortedArray {
    func search(_ nums: [Int], _ target: Int) -> Int {
        var left = 0, right = nums.count - 1
        while left <= right {
            let mid = (left + right) / 2
            if nums[mid] == target {
                return mid
            }

            // 1. 先找出有序区域
            // 2. 再确定target所在区域
            if nums[left] <= nums[mid] {
                if nums[left] <= target && target < nums[mid] {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if nums[mid] < target && target <= nums[right] {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return -1
    }
}
