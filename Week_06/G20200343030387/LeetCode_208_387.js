const TrieNode = function () {
    this.links = new Map()
    this._isEnd = false
}
TrieNode.prototype.setEnd = function () {
    this._isEnd = true
}
TrieNode.prototype.isEnd = function () {
    return this._isEnd
}
TrieNode.prototype.put = function (word, node) {
    this.links.set(word, node)
}
TrieNode.prototype.containsKey = function (word) {
    return this.links.has(word)
}
TrieNode.prototype.get = function (word) {
    return this.links.get(word)
}

/**
 * Initialize your data structure here.
 */
var Trie = function () {
    this.root = new TrieNode()
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
    let node = this.root
    let char = ''
    for (let i = 0; i < word.length; i++) {
        char = word[i]
        if (!node.containsKey(char)) {
            node.put(char, new TrieNode())
        }
        node = node.get(char)
    }
    node.setEnd()
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    const node = this._searchPrefix(word)
    return !!node && node.isEnd()
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    const node = this._searchPrefix(prefix)
    return !!node
};

Trie.prototype._searchPrefix = function (prefix) {
    let node = this.root
    let char = ''
    for (let i = 0; i < prefix.length; i++) {
        char = prefix[i]
        if (node.containsKey(char)) {
            node = node.get(char)
        } else {
            return null
        }
    }
    return node
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */