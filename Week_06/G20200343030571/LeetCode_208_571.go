package main

/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (65.17%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    27.8K
 * Total Submissions: 42.4K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 *
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 *
*/

// @lc code=start
/* const linkLen = 26

type Trie struct {
	link [linkLen]*Trie
	//value string
	isEnd bool
}


func Constructor() Trie {
	return Trie{}
}


func (this *Trie) Insert(word string) {
	curNode := this
	for _, c := range word {
		if curNode.link[c-'a'] == nil {
			curNode.link[c-'a'] = &Trie{}
		}
		curNode = curNode.link[c-'a']
	}
	curNode.isEnd = true
}


func (this *Trie) Search(word string) bool {
	curNode := this
	for _, c := range word {
		if curNode.link[c-'a'] == nil {
			return false
		}
		curNode = curNode.link[c-'a']
	}
	return curNode.isEnd
}


func (this *Trie) StartsWith(prefix string) bool {
	curNode := this
	for _, c := range prefix {
		if curNode.link[c-'a'] == nil {
			return false
		}
		curNode = curNode.link[c-'a']
	}
	return true
}
*/
/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end
