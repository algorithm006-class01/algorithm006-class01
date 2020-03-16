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
        self.root_node = {}
        self.end_of_word = "#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root_node
        for char in word:
            # 这里表示 如果node里面有char 就返回char的数据，没有就生成一个空字典更新到node里，并且返回这个空字典。相当于下面的三行
            node = node.setdefault(char, {})
            # if char not in node:
            #     node[char] = {}
            # node = node[char]
        node[self.end_of_word] = "#"
        print(self.root_node)

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root_node

        for char in word:
            if char not in node:
                return False
            node = node[char]
        # 这一行的目的主要是判断单词是否走完，比如apple 现在存入到字典树，如果不加这个app也会返回True
        return self.end_of_word in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root_node
        for char in prefix:
            if char not in node:
                return False

            node = node[char]
        return True


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))
    print(trie.search("app"))
