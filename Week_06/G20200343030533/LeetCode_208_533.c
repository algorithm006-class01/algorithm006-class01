#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <bool.h>

#define MAX_CHILD 26


typedef struct trie{
    int isEnd;
    struct trie* next[MAX_CHILD];
    
} Trie;

/** Initialize your data structure here. */

Trie* trieCreate() {
    Trie *root;
    root = (Trie *)malloc(sizeof(Trie) * 1 );
    memset(root, 0, sizeof(*root)); //不是root, 是*root
    return root;
}

/** Inserts a word into the trie. */
void trieInsert(Trie* obj, char * word) {
    Trie *node = obj;

    for (int i = 0; word[i] != '\0'; i++) {
        char c = word[i];
        if ( node->next[c-'a'] == NULL){
            node->next[c-'a'] = trieCreate();
        }
        node = node->next[c-'a'];
    }
    node->isEnd = 1;
}

/** Returns if the word is in the trie. */
bool trieSearch(Trie* obj, char * word) {
    Trie *node = obj;
    for (int i = 0; word[i] != '\0'; i++){
        char c = word[i];
        if ( node->next[c-'a'] == NULL){
            return false;
        }
        node = node->next[c-'a'];
    }
    return node->isEnd > 0;
  
}

/** Returns if there is any word in the trie that starts with the given prefix. */
bool trieStartsWith(Trie* obj, char * prefix) {
    Trie *node = obj;
    for (int i = 0; prefix[i] != '\0'; i++){
        char c = prefix[i];
        if ( node->next[c-'a'] == NULL){
            return false;
        }
        node = node->next[c-'a'];
    }
    return true;
  
}

//递归的方法
void trieFree(Trie* obj) {
    if (obj == NULL ) return;
    for (int i = 0; i < MAX_CHILD; i++){
        if (obj->next[i]){
            trieFree(obj->next[i]);
        }
    }
    free(obj);
}

