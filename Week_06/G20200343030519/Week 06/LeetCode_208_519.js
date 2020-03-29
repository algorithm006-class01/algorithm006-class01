// https://leetcode-cn.com/problems/implement-trie-prefix-tree/

class Trie {
  constructor() {
    this.root = {}
  }

  insert(word) {
    let curr = this.root
    word.split('').forEach(ch => (curr = curr[ch] = curr[ch] || {}))
    curr.isWord = true
  }

  traverse(word) {
    let curr = this.root
    for (let i = 0; i < word.length; i++) {
      if (!curr) return null
      curr = curr[word[i]]
    }
    return curr
  }

  search(word) {
    let node = this.traverse(word)
    return !!node && !!node.isWord
  }

  startsWith(word) {
    return !!this.traverse(word)
  }
}