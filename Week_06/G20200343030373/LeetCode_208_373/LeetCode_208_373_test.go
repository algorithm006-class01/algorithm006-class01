//https://leetcode-cn.com/problems/implement-trie-prefix-tree/
package implement_trie_array_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTrie(t *testing.T) {
	obj := Constructor()
	obj.Insert("apple")
	assert.Equal(t, true, obj.Search("apple"))
	assert.Equal(t, false, obj.Search("app"))
	assert.Equal(t, true, obj.StartsWith("app"))
	obj.Insert("app")
	assert.Equal(t, true, obj.Search("app"))
}

type Trie struct {
	isEnd    bool
	children [26]*Trie
}

func Constructor() Trie {
	return Trie{}
}

func (this *Trie) Insert(word string) {
	node := this
	for _, char := range word {
		index := char - 'a'
		if node.children[index] == nil {
			trie := Constructor()
			node.children[index] = &trie
		}
		node = node.children[index]
	}
	node.isEnd = true
}

func (this *Trie) Search(word string) bool {
	node := this
	for _, char := range word {
		index := char - 'a'
		node = node.children[index]
		if node == nil {
			return false
		}
	}
	return node.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {
	node := this
	for _, char := range prefix {
		index := char - 'a'
		node = node.children[index]
		if node == nil {
			return false
		}
	}
	return true
}
