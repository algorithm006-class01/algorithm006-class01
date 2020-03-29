class TrieNode;
typedef unordered_map<char, TrieNode> TrieNodeArray;

class TrieNode {
public:
    TrieNode() {
        child=nullptr;
        mIsEnd=false;
    }
    bool mIsEnd;
    TrieNodeArray* child;
};

class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        mRoot = new TrieNodeArray();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNodeArray* node = mRoot;
        for (int i=0; i<word.size(); i++) {
            auto iter = node->find(word[i]);
            if (iter==node->end()) {
                node->insert(make_pair(word[i],TrieNode()));
            }
            auto iter2 = node->find(word[i]);
            if (i==word.size()-1) {
                (iter2->second).mIsEnd=true;
            }
            else {
                if ((iter2->second).child==nullptr) {
                    (iter2->second).child = new TrieNodeArray();
                }

                node = (iter2->second).child;
            }
        }

        return;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNodeArray* node = mRoot;
        TrieNodeArray* pre = nullptr;
        for (auto &i:word) {
            if (node==nullptr) return false;

            auto iter = node->find(i);

            if (iter!=node->end()) {
                pre = node;
                node = (iter->second).child;
            }
            else {
                return false;
            }
        }

        auto iter2 = pre->find(word.back());

        return (iter2->second).mIsEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNodeArray* node = mRoot;
        for (auto &i:prefix) {
            if (node==nullptr) return false;

            auto iter = node->find(i);

            if (iter!=node->end()) {
                node = (iter->second).child;
            }
            else {
                return false;
            }
        }

        return true;
    }
private:
    TrieNodeArray* mRoot;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
