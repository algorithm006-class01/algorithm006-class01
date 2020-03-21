// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
package leetcode

type Trie struct {
	children [26]*Trie
	isLeaf   bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	chars := []byte(word)
	for cur, i := this, 0; i < len(chars); i++ {
		k := chars[i] - 'a'
		if cur.children[k] == nil {
			cur.children[k] = &Trie{}
		}

		cur = cur.children[k]
		if i == len(chars)-1 {
			cur.isLeaf = true
		}
	}
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	chars := []byte(word)
	cur := this
	for i := 0; i < len(chars); i++ {
		cur = cur.children[chars[i]-'a']
		if cur == nil {
			return false
		}
	}
	return cur.isLeaf
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	chars := []byte(prefix)
	for cur, i := this, 0; i < len(chars); i++ {
		if cur.children[chars[i]-'a'] == nil {
			return false
		}
		cur = cur.children[chars[i]-'a']
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
