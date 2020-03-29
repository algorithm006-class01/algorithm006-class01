package com.jk.week07;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_146_587 {
    Map<Integer,Node> cache;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LeetCode_146_587(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        //节点移动到头
        moveHead(node);
        return node.v;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        //新元素放头
        if (node == null) {
            node = new Node(key,value);
            addNode(node);
            cache.put(key, node);
            size++;
            //容器满了 删除尾
            if (size > capacity) {
                removeTail(tail.pre);
                size--;
            }
        }else {
            node.v = value;
            //已存在节点交换到头
            moveHead(node);
        }
    }

    private void removeTail(Node node) {
        remove(node);
        cache.remove(node.k);
    }

    private void moveHead(Node node) {
        remove(node);
        addNode(node);
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    class Node {
        Integer k;
        Integer v;
        Node pre;
        Node next ;
        public Node() {

        }

        public Node(Integer k, Integer v) {
            this.k = k;
            this.v = v;
        }
    }
}
