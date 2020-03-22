class Trie(object):
    def __init__(self):
        self.trie = {}

    def insert(self, word):
        t = self.trie
        for c in word:
            if c not in t:
                t[c] = {}  # 插入c 同时指向下一个字典
            t = t[c]
        t["-"] = True  # 这里的'-'就相当于前面声明的isEnd, 用来标记是不是结束了, 因为是用字典实现的所以可以随便声明key去标记

    def search(self, word):
        t = self.trie
        for c in word:
            if c not in t:
                return False
            t = t[c]
        return "-" in t

    def startsWith(self, prefix):
        t = self.trie
        for c in prefix:
            if c not in t:
                return False
            t = t[c]
        return True
