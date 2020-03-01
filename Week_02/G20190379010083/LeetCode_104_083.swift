//
//  0104_MaxinumDepthOfBinaryTree.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//  Created by Ryeagler on 2020/2/23.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class MaxinumDepthOfBinaryTree {
    func maxDepth(_ root: TreeNode<Any>?) -> Int {
        guard let node = root else {
            return 0
        }

        var queue = Queue<TreeNode<Any>>()
        queue.enqueue(node)
        var level = 0
        // 如果队列不为空，则进入循
        while queue.isEmpty == false {
            let size = queue.count
            for _ in 0..<size {
                if let tmpCode = queue.dequeue() {
                    if let left = tmpCode.left { queue.enqueue(left) }
                    if let right = tmpCode.right { queue.enqueue(right) }
                }
            }
            level += 1
        }
        return level
    }

    func maxDepth_Recursively(_ root: TreeNode<Int>?) -> Int {
        if root == nil {
            return 0
        }
        
        let leftDepth = maxDepth_Recursively(root?.left)
        let rightDepth = maxDepth_Recursively(root?.right)
        return max(leftDepth, rightDepth) + 1
    }
}
