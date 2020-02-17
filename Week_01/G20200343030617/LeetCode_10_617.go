//设计实现双端队列。
//你的实现需要支持以下操作：
//
//MyCircularDeque(k)：构造函数,双端队列的大小为k。
//insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
//insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
//deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
//deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
//getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
//getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
//isEmpty()：检查双端队列是否为空。
//isFull()：检查双端队列是否满了。

package main

//结点
type Node struct {
	Data int
	Pre  *Node
	Next *Node
}

type MyCircularDeque struct {
	First *Node
	Last  *Node
	Size  int
	Cap   int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	s := new(Node)
	s.Pre, s.Next = s, s
	return MyCircularDeque{s, s, 0, k}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.Cap == this.Size {
		return false
	}
	s := new(Node)
	s.Data = value
	s.Next = this.First.Next
	this.First.Next.Pre = s

	this.First.Next = s
	s.Pre = this.First
	if this.Size == 0 {
		this.Last = s
	}
	this.Size++
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.Cap == this.Size {
		return false
	}
	s := new(Node)
	s.Data = value
	this.Last.Next = s
	s.Pre = this.Last

	this.Last = s
	this.Last.Next = this.First
	this.First.Pre = this.Last
	this.Size++
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	s := this.First.Next //找到第一个节点
	this.First.Next = s.Next
	s.Next.Pre = this.First
	if this.Size == 1 {
		this.Last = this.First
	}
	this.Size--
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	s := this.Last.Pre //找到最后一个节点的前驱
	s.Next = this.First
	this.Last = s
	this.Size--
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.First.Next.Data
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.Last.Data
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.Size == 0
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.Cap == this.Size
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
