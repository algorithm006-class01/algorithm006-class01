/**
 * LRU的功能：
 * 
 * LRU的原理
 * 
 * https://www.jianshu.com/p/b1ab4a170c3c
 * 
 *  
 *  读缓存时从HashMap中查找key，更新缓存时同时更新HashMap和双向链表，双向链表始终按照访问顺序排列。
 * 值得一提的是，Java API中其实已经有数据类型提供了我们需要的功能，就是LinkedHashMap这个类。
 * 该类内部也是采用HashMap+双向链表实现的。使用这个类实现LRU就简练多了。
 * 
 */ 

import java.util.HashMap;
public class LRUCache {
    // 缓存容量
    private final int capacity;

    // 用于加速缓存项随机访问性能的HashMap
    private HashMap<Integer, Entry> map;

    // 双向链表头结点，该侧的缓存项访问时间较早
    private Entry head;

    // 双向链表尾结点，该侧的缓存项访问时间较新
    private Entry tail;

    // loadfactor是提供hashmap控制空间利用程度的，如果过高空间利用会好，但是元素hash冲突会增加，相反则相反
    // loadfactor的0.75是统计数据，为hashmap的性能均衡服务的

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Entry>((int)(capacity / 0.75 + 1), 0.75f);
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 从缓存中获取key对应的值，若未命中则返回-1
     * 若命中将缓存数据放到队列尾部
     * @param key 键
     * @return key对应的值，若未命中则返回-1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            popToTail(entry);
            return entry.value;
        }
        return -1;
    }

    /**
     * 向缓存中插入或更新值
     * @param key 待更新的键
     * @param value 待更新的值
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            popToTail(entry);
        } 
        else {
            Entry newEntry = new Entry(key, value);
            // 如果map里面的元素大于设置容量，要移除第一个元素
            if (map.size() >= capacity) {
                Entry first = removeFirst();
                map.remove(first.key);
            }
            // 把新元素放到末尾，新元素一直都是在尾部的
            addToTail(newEntry);
            map.put(key, newEntry);
        }
    }

    // 添加entry结点到链表末端
    private void addToTail(Entry entry) {
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    // 移除链表首端的结点
    // 就是把没有访问过的元素删除
    private Entry removeFirst() {
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    // 将entry结点移动到链表末端。刚使用过的，取数据后放到队尾
    // tail指针是个空值指针，它的prev是尾元素
    private void popToTail(Entry entry) {
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    /**
     * 缓存项的包装类，包含键、值、前驱结点、后继结点
     *
     */
    class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;
        
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * @param args
     * 测试程序，访问顺序为[[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]，其中成对的数调用put，单个数调用get。
     * get的结果为[1],[-1],[-1],[3],[4]，-1表示缓存未命中，其它数字表示命中。
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


}