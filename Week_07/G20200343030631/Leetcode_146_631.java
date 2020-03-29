import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 解题思路: 使用hashmap和linkedlist实现
 * 时间复杂度: O()
 * 空间复杂度: O()
 * 执行用时: 20 ms, 在所有 Java 提交中击败了78.10%的用户
 * 内存消耗: 53.4 MB, 在所有 Java 提交中击败了71.54%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/29
 */
public class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    static class LRUCache {
        private int capacity;
        private Map<Integer, Integer> innerMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            innerMap = new InnerLinkedHashMap<>(capacity);
        }

        public int get(int key){
            if (!innerMap.containsKey(key)){
                return -1;
            }
            return innerMap.get(key);
        }

        public void put(int key, int value){
            innerMap.put(key, value);
        }

        private static class InnerLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
            int maxiunCapacity;

            public InnerLinkedHashMap(int maxiunCapacity) {
                super(16,0.75f, true);
                this.maxiunCapacity = maxiunCapacity;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxiunCapacity;
            }
        }
    }


}
