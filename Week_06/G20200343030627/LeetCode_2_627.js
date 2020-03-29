// implement-trie-prefix-tree

/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.tree = {};
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    if (typeof word != 'string' || word.length == 0) return;

    var tempObj = this.tree;
    for (var i=0; i< word.length; i++) {
        if (!tempObj[word[i]]) tempObj[word[i]] = {};
        if (i == word.length -1) tempObj[word[i]].isEnd = true;
        tempObj = tempObj[word[i]];
    }
    return;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    if (typeof word != 'string' || word.length == 0) false;

    var tempObj = this.tree;
    for (var i=0;i< word.length; i++) {
        if (!tempObj[word[i]]) return false;
        if (i == word.length -1 && tempObj[word[i]].isEnd) return true;
        tempObj = tempObj[word[i]];
    }
    return false;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    if (typeof prefix != 'string' || prefix.length == 0) false;

    var tempObj = this.tree;
    for (var i=0;i< prefix.length; i++) {
        if (!tempObj[prefix[i]]) return false;
        if (i == prefix.length -1) return true;
        tempObj = tempObj[prefix[i]];
    }
};