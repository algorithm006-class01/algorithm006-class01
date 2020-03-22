package main

import (
	"strings"
)

/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (40.31%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    27.3K
 * Total Submissions: 67K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 *
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 *
 * 说明:
 *
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 *
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 */

// @lc code=start

func ladderLength1(beginWord string, endWord string, wordList []string) int {
	/* if wordList == nil || len(wordList) == 0 {
		return 0
	}

	mapNew := make(map[string]bool, len(wordList))
	for _, str := range wordList {
		mapNew[str] = true
	}
	if !mapNew[endWord] {
		return 0
	}

	//dfsFind(beginWord, endWord, 1, wordList, mapVisited)
	return bfsFind(beginWord, endWord, wordList, mapNew) */
	wordMap := make(map[string]bool, len(wordList))
	for _, v := range wordList {
		wordMap[v] = true
	}
	if !wordMap[endWord] {
		return 0
	}
	res := int(0)
	queue := []string{beginWord}

	for len(queue) > 0 {
		len := len(queue)
		res++
		for i := 0; i < len; i++ {
			popStr := queue[0]
			queue = queue[1:]
			for str, bNew := range wordMap {
				if !bNew || !isOneChatDiff(popStr, str) {
					continue
				}
				if strings.EqualFold(str, endWord) {
					return res + 1
				}

				queue = append(queue, str)
				wordMap[str] = false

			}
		}
	}
	return 0
}

/*
	双向BFS
	笔记：实现起来比之前想象中，与单项的区别要大一点。主要在于注释了#处，
	这里的顺序要比单项要让人注意一些。主要原因有以下2点:
	1. 由于set2里初始化时就存了endword，所以必须先检查是否能转化再看set2里是否存在，否则每次运行必然直接返回1
	2. 必须先检测set2里有没有再看是否是未访问状态，因为如果set2里有，即最终结果找到时，那个元素必然是被另一个访问过，
		如果先检测是否访问过，那么必然会每次都找不到最终返回0
	所以双向BFS每次遍历的检测顺序很固定：1.是否可转化 2.是否找到 3.是否访问过
*/
func ladderLength(beginWord string, endWord string, wordList []string) int {
	if wordList == nil || len(wordList) == 0 {
		return 0
	}

	mapNew := make(map[string]bool, len(wordList))
	for _, word := range wordList {
		mapNew[word] = true
	}
	if !mapNew[endWord] {
		return 0
	}

	set1, set2 := map[string]bool{beginWord: true}, map[string]bool{endWord: true}
	cnt := 0 //查找次数

	for len(set1) != 0 && len(set2) != 0 {
		len1, len2 := len(set1), len(set2)
		if len1 > len2 {
			set1, set2 = set2, set1
		}

		cnt++
		tmpSet := make(map[string]bool, 0)
		for curWord := range set1 {
			for _, w := range wordList {
				//#
				if !isOneChatDiff(w, curWord) {
					continue
				}
				if set2[w] {
					return cnt + 1
				}
				if !mapNew[w] {
					continue
				}

				mapNew[w] = false
				tmpSet[w] = true
			}
		}
		set1 = tmpSet
	}
	return 0
}

/*
func dfsFind(curWord, endWord string, curLev int, wordList []string, mapVisited map[string]bool, res *int) {
	if strings.EqualFold(curWord, endWord) {
		if curLev < result || result == 0 {
			result = curLev
			return
		}
	}

	for _, str := range wordList {
		bVisited, _ := mapVisited[str]
		if bVisited || !isOneChatDiff(curWord, str) {
			continue
		}
		mapVisited[str] = true
		dfsFind(str, endWord, curLev+1, wordList, mapVisited)
		mapVisited[str] = false
	}

	return
}
*/
func bfsFind(beginWord, endWord string, wordList []string, mapNew map[string]bool) int {
	queue := []string{beginWord}
	res := 0
	for len(queue) > 0 {
		len := len(queue)
		res++
		for i := 0; i < len; i++ {
			popStr := queue[0]
			queue = queue[1:]
			for _, str := range wordList {
				bNew, _ := mapNew[str]
				if !bNew || !isOneChatDiff(popStr, str) {
					continue
				}
				if strings.EqualFold(str, endWord) {
					return res + 1
				}

				mapNew[str] = false
				queue = append(queue, str)
			}
		}
	}
	return 0
}

func isOneChatDiff(wordA, wordB string) bool {
	count := 0
	runeA, runeB := []rune(wordA), []rune(wordB)
	len := len(runeA)
	for i := 0; i < len; i++ {
		if runeA[i] != runeB[i] {
			count++
		}
		if count > 1 {
			return false
		}
	}
	return count == 1
}

/* func main() {
	beginWord, endWord := "hit", "cog"
	wordList := []string{"hot", "dot", "dog", "lot", "log", "cog"}
	//wordList := []string{"hot", "dot", "dog", "lot", "log"}
	res := ladderLength(beginWord, endWord, wordList)
	fmt.Println(res)
	return
} */

// @lc code=end
