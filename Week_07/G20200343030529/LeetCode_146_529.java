class LRUCache {

      class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;
        }

        private void addNode(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(LinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private LinkedNode popTail() {
            LinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, LinkedNode> cache = new HashMap<>();
        private int size = 0;
        private int capacity = 0;
        private LinkedNode head;
        private LinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            LinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node != null) {
                node.key = key;
                node.value = value;
                moveToHead(node);
                return;
            }
            if (size < capacity) {
                node = new LinkedNode();
                node.key = key;
                node.value = value;
                addNode(node);
                cache.put(key, node);
                size++;
            } else {
                node = popTail();
                removeNode(node);
                cache.remove(node.key);
                node.key = key;
                node.value = value;
                addNode(node);
                cache.put(key, node);
            }
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */