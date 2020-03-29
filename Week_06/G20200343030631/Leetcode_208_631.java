package com.dsx.twohundred.zero.eight;

/**
 * 解题思路: 经典解题实现，用trienode表示trie树节点，然后逐层引用生成下一层；
 * 时间复杂度:
 * 空间复杂度:
 * 执行用时: 48 ms, 在所有 Java 提交中击败了61.93%的用户
 * 内存消耗: 54.3 MB, 在所有 Java 提交中击败了24.88%的用户
 * @Author: loe881@163.com
 * @Date: 2020/3/18
 */
public class Solution {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
        System.out.println(param_2);
        boolean param_3 = obj.startsWith("wo");
        System.out.println(param_3);
        boolean param_4 = obj.startsWith("rd");
        System.out.println(param_4);
    }

    static class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar= word.charAt(i);
                if (!node.containsKey(currentChar)){
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchInternal(word);
            return null != node && node.isEnd();
        }

        private TrieNode searchInternal(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.containsKey(currentChar)){
                    node = node.get(currentChar);
                }else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchInternal(prefix);
            return null != node;
        }

        class TrieNode{
            // 存储下一层指向
            private TrieNode[] nodes;

            // 存储初始容量，26个英文字母
            private final int SIZE = 26;

            // 存储是否为结束节点，即到达trie树叶子
            private boolean isEndNode;

            public TrieNode() {
                this.nodes = new TrieNode[SIZE];
            }

            public boolean containsKey(char ch) {
                return nodes[ch -'a'] != null;
            }
            public TrieNode get(char ch) {
                return nodes[ch -'a'];
            }
            public void put(char ch, TrieNode node) {
                nodes[ch -'a'] = node;
            }
            public void setEnd() {
                isEndNode = true;
            }
            public boolean isEnd() {
                return isEndNode;
            }
        }
    }

}
