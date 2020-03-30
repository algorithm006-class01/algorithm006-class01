package lrucache;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的
//数据值留出空间。
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146.lru-cache
 * LRU缓存机制
 * 使用有序字典数据结构 java中 LinkedHashMap Python中 OrderedDict
 */
public class LruCache {
    public static void main(String[] args) {
        LruCache solution = new LruCache();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            /**
             * super可以用来引用直接父类的实例变量。
             * super可以用来调用直接父类方法。
             * super()可以用于调用直接父类构造函数。
             * //原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/super-keyword.html
             * super(capacity, 0.75F, true);  LinkedHashMap(int initialCapacityfloat loadFactor, boolean accessOrder) 使用指定的初始容量，负载因子和accessOrder构造一个空的LinkedHashMap实例。
             * int initialCapacity, 初始容量
             * float loadFactor, 负载因子
             * boolean accessOrder true：表示希望根据访问顺序（而不是插入顺序）遍历条目。false：插入顺序
             *  */
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
//            getOrDefault 取到返回，否则返回默认值
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * removeEldestEntry() 通过覆盖这个方法，加入一定的条件，满足条件返回true。当put进新的值方法返回true时，便移除该map中最老的键和值。
         * @param eldest
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

/**
 *  LRUCache 对象会以如下语句构造和调用:
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}