#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

using namespace std;

//第一种实现方法: 基于class, 声明两个成员变量(isEnd和next), 每次都需要创建新的类。速度慢
class Trie {
private:
    bool isEnd;
    Trie* next[26];
public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd=false;
        memset(next, 0, sizeof(next));

    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* node = this;
        for ( char c : word){
            if (node->next[c-'a'] == NULL){
                node->next[c-'a'] = new Trie();
            }
            node = node->next[c-'a'];
        }
        node->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* node = this;
        for ( char c : word){
            node = node->next[c-'a'];
            if ( node == NULL){
                return false;
            }
        }
        return node->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* node = this;
        for ( char c : prefix){
            node = node->next[c-'a'];
            if ( node == NULL){
                return false;
            }
        }
        return true;
    }
};

// 第二种方法: 和方法一，整体相同，只不过通过结构体定义Node, 执行速度快
class Trie {
    //定义每个节点的结构
    struct Node{
        int isEnd;
        Node *next[26] ={NULL};
        Node(int val) { isEnd = val;};
    };
private:
    Node* root;
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new Node(0);
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Node *node = root;
        for ( char c : word){
            if ( node->next[c-'a'] == NULL){
                node->next[c-'a'] = new Node(0);
            }
            node = node->next[c-'a'];
        }
        node->isEnd = 1;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Node *node = root;
        for ( char c : word){
            if ( node->next[c-'a'] == NULL){
                return false;
            }
            node = node->next[c-'a'];
        }
        return node->isEnd > 0;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Node *node = root;
        for ( char c : prefix){
            if ( node->next[c-'a'] == NULL){
                return false;
            }
            node = node->next[c-'a'];
        }
        return true;

    }
};
