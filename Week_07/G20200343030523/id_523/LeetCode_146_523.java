package lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 */
public class LRUCache01 {

    private Entry head;
    private Entry tail;
    private Map<Integer, Entry> cache;
    private int capacity;

    public LRUCache01(int capacity) {
        this.capacity = capacity;
        this.head = new Entry(0, 0);
        this.tail = new Entry(0, 0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.cache = new HashMap<>((int) (capacity / 0.75 + 1), 0.75f);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Entry entry = cache.get(key);
            entry.value = value;
            popToTail(entry);
        } else {
            Entry newEntry = new Entry(key, value);
            if (cache.size() >= capacity) {
                Entry first = removeFirst();
                cache.remove(first.key);
            }
            addToTail(newEntry);
            cache.put(key, newEntry);
        }
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Entry entry = cache.get(key);
            popToTail(entry);
            return entry.value;
        }
        return -1;
    }

    class Entry {
        int key;
        int value;
        Entry pre;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void popToTail(Entry entry) {
        Entry pre = entry.pre;
        Entry next = entry.next;
        pre.next = next;
        next.pre = pre;
        Entry last = tail.pre;
        last.next = entry;
        entry.pre = last;
        entry.next = tail;
        tail.pre = entry;
    }

    private Entry removeFirst() {
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.pre = head;
        return first;
    }

    private void addToTail(Entry entry) {
        Entry last = tail.pre;
        last.next = entry;
        entry.pre = last;
        entry.next = tail;
        tail.pre = entry;
    }

    public static void main(String[] args) {
        LRUCache01 cache = new LRUCache01(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

}
