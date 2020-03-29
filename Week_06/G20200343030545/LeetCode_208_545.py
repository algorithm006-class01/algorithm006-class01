"""
    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

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
"""


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self._end_flag = "#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self._end_flag] = self._end_flag

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self._end_flag in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True
