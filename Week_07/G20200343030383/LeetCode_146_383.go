// https://leetcode-cn.com/problems/lru-cache/

type LRUCache struct {
	hash map[int]*node
	link *dlink
	size int
	cap  int
}
type node struct {
	Key, Val   int
	Next, Prev *node
}

type dlink struct {
	head, rear *node
}

func newDlink() *dlink {
	head, rear := &node{}, &node{}
	head.Next = rear
	rear.Prev = head
	return &dlink{head: head, rear: rear}
}

func (l *dlink) remove(n *node) {
	n.Prev.Next = n.Next
	n.Next.Prev = n.Prev
}

func (l *dlink) add(n *node) {
	n.Next = l.head.Next
	n.Prev = l.head
	l.head.Next.Prev = n
	l.head.Next = n
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		hash: make(map[int]*node),
		cap:  capacity,
		link: newDlink(),
	}
}

func (this *LRUCache) Get(key int) int {
	n, ok := this.hash[key]
	if !ok {
		return -1
	}
	this.link.remove(n)
	this.link.add(n)
	return n.Val
}

func (this *LRUCache) Put(key int, value int) {
	n, ok := this.hash[key]
	if ok {
		this.link.remove(n)
		this.link.add(n)
		n.Val = value
		return
	}
	if this.size == this.cap {
		delete(this.hash, this.link.rear.Prev.Key)
		this.link.remove(this.link.rear.Prev)
		this.size--
	}
	n = &node{Key: key, Val: value}
	this.link.add(n)
	this.hash[key] = n
	this.size++

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

