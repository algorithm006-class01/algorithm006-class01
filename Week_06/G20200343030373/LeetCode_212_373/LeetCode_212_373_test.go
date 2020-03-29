//https://leetcode-cn.com/problems/word-search-ii/
package word_search_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestWordSearch(t *testing.T) {
	t.Log("Word Search II: Trie")
	words := []string{"oath", "pea", "eat", "rain"}
	board := [][]byte{
		{'o', 'a', 'a', 'n'},
		{'e', 't', 'a', 'e'},
		{'i', 'h', 'k', 'r'},
		{'i', 'f', 'l', 'v'},
	}
	expect := []string{"oath", "eat"}
	assert.Equal(t, expect, findWords(board, words))
}

func findWords(board [][]byte, words []string) []string {
	var res []string

	resMap := make(map[string]bool)

	trie := Trie{}
	for _, word := range words {
		trie.Insert(word)
	}

	m := len(board)
	n := len(board[0])
	visited := make([][]bool, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(board, visited, "", i, j, trie, &resMap)
		}
	}

	for key := range resMap {
		res = append(res, key)
	}

	return res
}

func dfs(board [][]byte, visited [][]bool, str string, x int, y int, trie Trie, resMap *map[string]bool) {
	if x < 0 || x >= len(board) || y < 0 || y >= len(board[0]) {
		return
	}

	if visited[x][y] {
		return
	}

	str += string(board[x][y])
	if !trie.StartsWith(str) {
		return
	}

	if trie.Search(str) {
		(*resMap)[str] = true
	}

	visited[x][y] = true
	dfs(board, visited, str, x-1, y, trie, resMap)
	dfs(board, visited, str, x+1, y, trie, resMap)
	dfs(board, visited, str, x, y-1, trie, resMap)
	dfs(board, visited, str, x, y+1, trie, resMap)
	visited[x][y] = false
}

//Trie
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
