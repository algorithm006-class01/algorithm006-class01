package main
import(
	"container/list"
)

type cacheItem struct{
	key, value int
}

type LRUCache struct {
	cap int
	elementMap map[int]*list.Element
	listCache *list.List
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		cap: capacity,
		elementMap: make(map[int]*list.Element),
		listCache: list.New(),
	}
}

func (lru *LRUCache) Get(key int) int {
	v, ok := lru.elementMap[key]
	if !ok {
		return -1
	}
	lru.listCache.MoveToFront(v)
	return v.Value.(*cacheItem).value
}

func (lru *LRUCache) Put(key int, value int)  {
	v, ok := lru.elementMap[key]
	if ok {
		v.Value.(*cacheItem).value = value
		lru.listCache.MoveToFront(v)
		return
	}

	if lru.listCache.Len() >= lru.cap {
		lru.RemoveOldest()
	}

	item := &cacheItem{
		key: key,
		value: value,
	}
	element := lru.listCache.PushFront(item)
	lru.elementMap[key] = element
}

func (lru *LRUCache) RemoveOldest() {
	element := lru.listCache.Back()
	lru.listCache.Remove(element)
	delete(lru.elementMap, element.Value.(*cacheItem).key)
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */