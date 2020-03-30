
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @date Mar 25 2020
// @solution LinkedHashMap
// class LRUCache extends LinkedHashMap<Integer, Integer>{
//     private int capacity;
//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }
    
//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity;
//     }
// }

// @lc code=start
// @date Mar 25 2020
// @solution HashMap DLinkedList
import java.util.Hashtable;
class LRUCache {
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new DLinkedNode();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        addNode(node);
        if (++size > capacity) {
            DLinkedNode tail = popTail();
            cache.remove(tail.key);
            size --;
        }
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }
    
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end