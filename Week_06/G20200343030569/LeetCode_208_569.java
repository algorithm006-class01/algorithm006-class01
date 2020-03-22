/*
 * 208. Implement Trie (Prefix Tree)
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

 */
public class LeetCode_208_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	class Trie {
		
		class TrieNode {
			char value;
			boolean bWord;
			TrieNode[] children = new TrieNode[26];
			
			public TrieNode(){}
			public TrieNode(char c) {
				value = c;
			}
			
			public TrieNode get( char c ) {
				return children[c-'a'];
			}
			
			public void set( char c, TrieNode node ) {
				children[c-'a'] = node;
			}
			
			public boolean contain( char c ) {
				return children[c-'a'] != null;
			}
			
			public void setWord() {
				bWord = true;
			}
			
			public boolean isWord() {
				return bWord;
			}
		}
		
		TrieNode root;
		
	    /** Initialize your data structure here. */
	    public Trie() {
	    	root = new TrieNode(' ');
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	TrieNode node = root;
	    	for( int i = 0; i < word.length(); i++ ) {
	    		if( !node.contain(word.charAt(i)) )
	    			node.set(word.charAt(i), new TrieNode(word.charAt(i)));
	    		node = node.get(word.charAt(i));
	    	}
	    	node.setWord();
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	TrieNode node = root;
	    	for( int i = 0; i < word.length(); i++ ) {
	    		if( !node.contain(word.charAt(i)) )
	    			return false;
	    		node = node.get(word.charAt(i));
	    	}
	    	return node.isWord();
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	TrieNode node = root;
	    	for( int i = 0; i < prefix.length(); i++ ) {
	    		if( !node.contain(prefix.charAt(i)) )
	    			return false;
	    		node = node.get(prefix.charAt(i));
	    	}
	    	return true;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
