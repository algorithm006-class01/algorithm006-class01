# 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
# 
#  示例: 
# 
#  Trie trie = new Trie();
# 
# trie.insert("apple");
# trie.search("apple");   // 返回 true
# trie.search("app");     // 返回 false
# trie.startsWith("app"); // 返回 true
# trie.insert("app");   
# trie.search("app");     // 返回 true 
# 
#  说明: 
# 
#  
#  你可以假设所有的输入都是由小写字母 a-z 构成的。 
#  保证所有输入均为非空字符串。 
#  
#  Related Topics 设计 字典树


# leetcode submit region begin(Prohibit modification and deletion)
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        tree = self.root
        for char in word:
            if char not in tree:
                tree[char] = {}
            tree = tree[char]
        tree['#'] = '#'
        return True


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        tree = self.root
        for char in word:
            if char in tree:
                tree = tree[char]
            else:
                return False
        return True if '#' in tree else False


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        tree = self.root
        for char in prefix:
            if char in tree:
                tree = tree[char]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
obj = Trie()
print(obj.insert('apple'))
print(obj.search('ap'))
print(obj.startsWith('ap'))
# leetcode submit region end(Prohibit modification and deletion)
