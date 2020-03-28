import java.util.*;

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;

    DLinkedNode() {

    }

    DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int capacity;
    private int count;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;

    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode preNode = node.pre;
        DLinkedNode postNode = node.post;

        preNode.post = postNode;
        postNode.pre = preNode;

    }

    private void removeAndMoveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode tailRre = tail.pre;
        removeNode(tailRre);
        return tailRre;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        removeAndMoveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            node = new DLinkedNode(key, value);
            count++;
            cache.put(key, node);
            addNode(node);

            if(count > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            removeAndMoveToHead(node);

        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */