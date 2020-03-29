
class LeetCode_192_505 {
    private DoubleList list;
    private Map<Integer, ListNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new DoubleList();
        this.map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        //调整链表节点 先删除key节点 再放一个新的节点到头部
        list.removeNode(map.get(key));
        //下面写法是有bug的  new出来的和map里的就不同了，应该放入map里的
        //list.addFrist(new ListNode(key, val));
        list.addFrist(map.get(key));

        return val;
    }
    
    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (map.containsKey(key)) {
            //如果已经有该元素，调整链表 然后更新map
            list.removeNode(map.get(key));
            list.addFrist(node);
            map.put(key, node);
        } else {
            //空元素 先判断容量 如果超了就溢出头部节点 再插入
            //此处比较 链表的容量和当前容量
            if (this.capacity == this.list.size()) {
                ListNode pLast = list.removeLast();                
                map.remove(pLast.key);               
            }
            
            list.addFrist(node);
            map.put(key, node);
        }

    }
}

//定义节点类 存储节点信息 包括前驱指针和后驱指针
class ListNode {
    public int key, val;
    public ListNode pre, next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//定义一个双向链表
class DoubleList {
    private int size;
    private ListNode head, tail;
    public int size() {
        return size;
    }
    //虚拟节点
    public DoubleList() {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        //head指向尾部节点 tail指向头部节点
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    //头插入
    public void addFrist(ListNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        ++size;
    }
    //尾插入
    public void addLast(ListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        ++size;
    }

    public ListNode removeLast() {
        //判断是否是空链表
        if (tail.pre == head) {
            return null;
        }
        ListNode pLast = tail.pre;
        removeNode(tail.pre);
       return pLast;
    }

    public void removeNode(ListNode node) {
        //当前节点前驱指向节点下驱
        node.pre.next = node.next;
        //当前节点下驱指向节点前驱
        node.next.pre = node.pre;
        //别忘了元素减少一个
        --size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */