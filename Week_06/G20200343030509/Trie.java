package com.leetcode.week06;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

  private TrieNode root;

  public  Trie () {
    root = new TrieNode();
  }

  class TrieNode {
    private TrieNode[] links;
    private final int size = 26;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public TrieNode() {
      links = new TrieNode[26];
    }

    public boolean containsKey (char ch) {
      return links[ch - 'a'] != null;
    }

    public TrieNode get (char ch) {
      return links[ch - 'a'];
    }

    public void put (char ch, TrieNode node) {
      links[ch - 'a'] = node;
    }

    public void setEnd () {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }


  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch, new TrieNode());
      }
      node = node.get(ch);
    }
    node.setEnd();
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  private Trie.TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containsKey(ch)) {
        node = node.get(ch);
      }
      else {
        return null;
      }
    }
    return node;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

