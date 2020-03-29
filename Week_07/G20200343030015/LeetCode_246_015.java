package G20200343030015.week_07;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by majiancheng on 2020/3/29.
 * <p>
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_246_015 {
    private Map<Integer, Node> map;

    private DoubleList doubleList;

    private Integer capacity;
    public LeetCode_246_015(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.doubleList = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        //如果包含元素
        if(map.containsKey(key)) {
            doubleList.remove(map.get(key));
        } else {
            if(capacity == doubleList.size()) {
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
        }

        Node node = new Node(key, value);
        doubleList.addFirst(node);
        map.put(key, node);
    }


    //双端队列
    class DoubleList {
        private Node head, tail;

        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size ++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size --;
        }

        public Node removeLast() {
            if(head.next == tail) {
                return null;
            }
            Node node = tail.prev;
            this.remove(node);

            return node;
        }

        public int size() {
            return this.size;
        }

    }

    //队列节点
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
