package main

import (
	"strings"
	"fmt"
)

/*
126. 单词接龙 II

给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。

转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。

说明:
如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

*/

/*
	虽然刚刷完成语接龙1的题目，自己对这题也有大概的思路。但是代码就是写不出来。
	原因在于不知道怎么才能把所有的路径存下来。以及如何退出

	通过看别人的题解有了思路。
	这道题卡了几个小时，一直有问题。直到目前这个版本还是有问题的。应该是出在golang的slice上。
	目前有一定概率在执行
		pushPath := append(path, str)
	这句语句时，会修改到res的结果，导致最终结果错误。
	这是因为golang后根据相同数组派生出的slice会引用同一底层数组导致。
	但还没想好怎么改。先保留。

*/
func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	mapWord := make(map[string]bool, len(wordList))
	for _, str := range wordList {
		mapWord[str] = true
	}
	res := make([][]string, 0)
	if !mapWord[endWord] { return res}

	pathQueue := [][]string{{beginWord}}
	bFound := false
	for len(pathQueue) != 0 && !bFound {
		tmpQueue := pathQueue
		for _, path := range tmpQueue {
			pathQueue = pathQueue[1:]
			popStr := path[len(path) - 1]
			for str := range mapWord {
				if isFoundInThisPath(path, str) || !isOnlyOneCharDiff2(str, popStr) {
					continue
				}
				pushPath := append(path, str)
				if strings.EqualFold(str, endWord) {
					bFound = true
					res = append(res, pushPath)
				} else {
					pathQueue = append(pathQueue, pushPath)
				}
			}
		}
	}
	return res
}

func isOnlyOneCharDiff2(str1, str2 string) bool {
	rune1 := []rune(str1)
	rune2 := []rune(str2)
	diffNum := int(0)
	len := len(rune1)
	for i := 0; i < len; i++ {
		if rune1[i] != rune2[i] {
			diffNum++
			if diffNum > 1 {
				return false
			}
		}
	}
	return diffNum == 1
}

func isFoundInThisPath(path []string, str string) bool {
	for _, s := range path {
		if strings.EqualFold(s, str) {
			return true
		}
	}
	return false
}
/*
"red"
"tax"
["ted","tex","red","tax","tad","den","rex","pee"]

输出
[["red","rex","tex","tax"],["red","ted","tad","tax"]]
预期结果
[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
*/
func main() {
	wordList := []string{"ted","tex","red","tax","tad","den","rex","pee"}
	res := findLadders("red", "tax", wordList)
	fmt.Println(res)
}










