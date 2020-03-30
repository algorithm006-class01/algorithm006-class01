package main

/*
 * @lc app=leetcode.cn id=146 lang=golang
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (46.04%)
 * Likes:    455
 * Dislikes: 0
 * Total Accepted:    40.6K
 * Total Submissions: 87.4K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 缓存容量 );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 *
*/

// @lc code=start
type LRUCache struct {
	cap     int
	head    *Node
	tail    *Node
	nodeMap map[int]*Node
}

type Node struct {
	prev  *Node
	next  *Node
	key   int
	value int
}

func Constructor(capacity int) LRUCache {
	cache := LRUCache{
		cap:     capacity,
		nodeMap: make(map[int]*Node, capacity+1),
		head:    &Node{},
		tail:    &Node{},
	}
	cache.head.next = cache.tail
	cache.tail.prev = cache.head
	return cache
}

func (this *LRUCache) Get(key int) int {
	node, ok := this.nodeMap[key]
	if !ok {
		return -1
	}

	/* this.Remove(node)
	this.SetHeader(node) */
	return node.value
}

func (this *LRUCache) Put(key int, value int) {
	node, ok := this.nodeMap[key]
	if ok {
		this.Remove(node)
		this.SetHeader(node)
		return
	}

	node = &Node{
		key:   key,
		value: value,
	}
	this.SetHeader(node)
	this.nodeMap[key] = node

	if len(this.nodeMap) > this.cap {
		delete(this.nodeMap, this.tail.prev.key)
		this.Remove(this.tail.prev)
	}
}

func (this *LRUCache) Remove(node *Node) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (this *LRUCache) SetHeader(node *Node) {
	node.prev = this.head
	node.next = this.head.next
	this.head.next.prev = node
	this.head.next = node
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

/* func main() {
	cache := Constructor(2)
	cache.Put(1, 1)
	cache.Put(2, 2)
	cache.Get(1)
	cache.Put(3, 3)
	cache.Get(2)
	cache.Put(4, 4)
	cache.Get(1)
	cache.Get(3)
	cache.Get(4)
} */

// @lc code=end
