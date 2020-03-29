//
//  0146_LRUCache.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/lru-cache/
//  Created by Ryeagler on 2020/3/29.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class LRUCache {
    
    class LinkNode {
        var key: Int
        var value: Int
        var next: LinkNode?
        var prev: LinkNode?
        
        init(_ key: Int, _ value: Int) {
            self.key = key
            self.value = value
        }
    }
    
    let capacity: Int
    // The number of values currently being stored
    private var usage = 0
    private var elements = [Int: LinkNode]()
    // The most recently used node
    private var head: LinkNode?
    // The least recently used node
    private var tail: LinkNode?
    
    init(_ capacity: Int) {
        self.capacity = capacity
    }
    
    func get(_ key: Int) -> Int {
        guard let node = elements[key] else {
            return -1
        }
        
        updateUsage(of: node)
        
        return node.value
    }
    
    func put(_ key: Int, _ value: Int) {
        // Key already exists
        if let existing = elements[key] {
            existing.value = value
            updateUsage(of: existing)
        }
        // Add new key
        else if usage < capacity {
            let node = LinkNode(key, value)
            elements[key] = node
            if let head = self.head {
                head.next = node
                node.prev = head
                self.head = node
            }
            else {
                self.head = node
            }
            if tail == nil {
                tail = node
            }
            usage += 1
        }
        // Replace least-used key
        else if let tail = self.tail {
            elements[tail.key] = nil
            tail.key = key
            tail.value = value
            elements[key] = tail
            updateUsage(of: tail)
        }
    }
    
    // Moves `node` to the head of the usage list
    private func updateUsage(of node: LinkNode) {
        if let next = node.next {
            node.next = nil
            next.prev = nil
            
            if let prev = node.prev {
                node.prev = nil
                prev.next = next
                next.prev = prev
            }
            else if self.tail === node {
                self.tail = next
            }
            
            if let head = self.head {
                node.prev = head
                head.next = node
            }
            
            head = node
        }
    }
}
