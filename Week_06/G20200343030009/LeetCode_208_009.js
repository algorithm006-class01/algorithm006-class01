/*
  208. 实现 Trie (前缀树)
  实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

  示例:
  Trie trie = new Trie();

  trie.insert("apple");
  trie.search("apple");   // 返回 true
  trie.search("app");     // 返回 false
  trie.startsWith("app"); // 返回 true
  trie.insert("app");   
  trie.search("app");     // 返回 true
  说明:
  你可以假设所有的输入都是由小写字母 a-z 构成的。
  保证所有输入均为非空字符串。
*/
var Trie = function() {
  this.root = {}
  this.end_of_word = '#'
};
Trie.prototype.insert = function(word) {
  let node = this.root
  for (let char of word) {
      if (!node.hasOwnProperty(char)) node[char] = {}
      node = node[char] 
  }
  node.end_of_word = this.end_of_word
};
Trie.prototype.search = function(word) {
  let node = this.root
  for (let char of word) {
      if (!node.hasOwnProperty(char)) return false
      node = node[char]
  }
  return node.hasOwnProperty('end_of_word')
};
Trie.prototype.startsWith = function(prefix) {
  let node = this.root
  for (let char of prefix) {
      if (!node.hasOwnProperty(char)) return false
      node = node[char]
  }
  return true
};