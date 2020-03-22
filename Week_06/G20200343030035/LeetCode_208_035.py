'''
208. 实现 Trie (前缀树)

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例：
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true

说明：
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

'''
class TrieNode:
    def __init__(self):
        self.children = [0]*26
        self.is_word = False
  
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
    
    def _char_to_index(self,char):
        return ord(char) - ord("a")

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        start = self.root
        for char in word:
            index = self._char_to_index(char)
            if not start.children[index]:
                start.children[index] = TrieNode()
            start = start.children[index]
        start.is_word = True
        
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        start = self.root
        for char in word:
            index = self._char_to_index(char)
            if not start.children[index]:
                return False
            start = start.children[index]
        if start.is_word: return True
        return False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        start = self.root
        for char in prefix:
            index = self._char_to_index(char)
            if not start.children[index]:
                return False
            start = start.children[index]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)