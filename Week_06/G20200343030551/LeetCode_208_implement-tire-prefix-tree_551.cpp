#include <iostream>

using namespace std;

class Trie
{
public:
    /** Initialize your data structure here. */
    Trie()
    {
        isEnd = false;
        for (int i = 0; i < 26; i++)
            next[i] = NULL;
    }

    /** Inserts a word into the trie. */
    void insert(string word)
    {
        Trie *root = this;
        for (const auto &item:word)
        {
            if (root->next[item - 'a'] == NULL)
                root->next[item - 'a'] = new Trie();
            root = root->next[item - 'a'];
        }
        root->isEnd = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word)
    {
        Trie *root = this;
        for (const auto &item:word)
        {
            if (root->next[item - 'a'] == NULL)
                return false;
            root = root->next[item - 'a'];
        }
        return root->isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix)
    {
        Trie *root = this;
        for (const auto &item:prefix)
        {
            if (root->next[item - 'a'] == NULL)
                return false;
            root = root->next[item - 'a'];
        }
        return true;
    }

private:
    bool isEnd;
    Trie *next[26];
};
