package leetcode

/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (64.22%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 42.9K
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
type Trie struct {
	ret map[string]bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		ret: make(map[string]bool),
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	this.ret[word] = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	return this.ret[word]

}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	if this.ret[prefix] {
		return true
	}

	for i := range this.ret {
		var flag int
		if len(i) < len(prefix) {
			continue
		}

		for k := range prefix {
			if i[k] != prefix[k] {
				break
			} else {
				flag++
			}

			if flag == len(prefix) {
				return true
			}
		}
	}
	return false

}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end
