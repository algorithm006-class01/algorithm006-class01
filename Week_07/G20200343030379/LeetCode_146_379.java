package G20200343030379;

import java.awt.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个? LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在?O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/
 */
public class LeetCode_146_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * 执行用时 : 19 ms , 在所有 Java 提交中击败了 90.06% 的用户
     * 内存消耗 : 50.6 MB , 在所有 Java 提交中击败了 89.88% 的用户
     */
    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity=capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size()>capacity;
        }
    }

    /**
     * 方法二：第一种方法基本上，只是写法不同
     *
     * 执行用时 : 23 ms , 在所有 Java 提交中击败了 62.61% 的用户
     * 内存消耗 : 50.7 MB , 在所有 Java 提交中击败了 86.75% 的用户
     * 优秀题解；https://leetcode.com/problems/lru-cache/discuss/46055/Probably-the-%22best%22-Java-solution-extend-LinkedHashMap
     */
    class LRUCache3 {
        private int capacity;
        private Map<Integer,Integer> map;

        public LRUCache3(int capacity) {
            this.map=new  LinkedHashMap<Integer,Integer>(16,0.75f,true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size()>capacity;
                }
            };
            this.capacity=capacity;
        }

        public int get(int key) {
            return map.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            map.put(key,value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


    class DoubleList{
        private Node head,tail;
        private int size;

        DoubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        public void addFirst(Node x){
            x.next=head.next;
            x.prev=head;
            head.next.prev=x;
            head.next=x;
            size++;
        }

        public void remove(Node x){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            size--;
        }

        public Node removeLast(){
            if(tail.prev==head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }
}

    class Node {
        public  int key,val;
        public Node next,prev;

        Node(int k ,int v){
            this.key=k;
            this.val=v;
        }

    }

    /**
     * 方法三：自己搞一个hashmap和双向链表
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 71.79% 的用户
     * 内存消耗 : 53.3 MB , 在所有 Java 提交中击败了 71.50% 的用户
     */
    class LRUCache2{
        private HashMap<Integer,Node> map;
        private DoubleList cache;
        private int cap;

        LRUCache2(int capacity){
            this.cap=capacity;
            cache=new DoubleList();
            map=new HashMap<>();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                this.put(node.key,node.val);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node=new Node(key,value);
            if(map.containsKey(key)){

                cache.remove(map.get(key));
            }else{
                if(cap==cache.getSize()){
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
}
