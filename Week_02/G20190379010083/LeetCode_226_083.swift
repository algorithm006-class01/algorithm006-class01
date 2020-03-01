//
//  0226_InvertBinaryTree.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2020/2/23.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class InvertBinaryTree {
    func invertTree(_ root: TreeNode<Any>?) -> TreeNode<Any>? {
        guard let node = root else  {
            return nil
        }
        
        var queue = Queue<TreeNode<Any>>()
        queue.enqueue(node)
        while queue.isEmpty == false {
            let count = queue.count
            for _ in 0..<count {
                if let frontNode = queue.dequeue() {
                    let tmp = frontNode.left
                    frontNode.left = frontNode.right
                    frontNode.right = tmp
//                    if let left = frontNode.left { queue.enqueue(left) }
//                    if let right = frontNode.left { queue.enqueue(right) }
                    if frontNode.left != nil { queue.enqueue(frontNode.left!) }
                    if frontNode.right != nil { queue.enqueue(frontNode.right!) }
                }
            }
        }
        
        return node
    }
    
    func invertTree_Recursively(_ root: TreeNode<Any>?) -> TreeNode<Any>? {
        guard let node = root else {
            return nil
        }
        node.left = invertTree_Recursively(node.left)
        node.right = invertTree_Recursively(node.right)
        return node
    }
}
