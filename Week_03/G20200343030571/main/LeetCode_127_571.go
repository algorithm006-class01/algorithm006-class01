package main

import (
	"strings"
	"fmt"
)

/*
127. 单词接龙

给定两个单词（beginWord 和 endWord）和一个字典，
找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。

示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

*/

/*
	思路：回溯
	worldList 存map[string]bool bool标记是否读过
	然后发现超时了
*/
func ladderLength1(beginWord string, endWord string, wordList []string) int {
	wordMap := make(map[string]bool, len(wordList))
	for _, v := range wordList {
		wordMap[v] = true
	}
	if !wordMap[endWord] {return 0}

	res := int(0)
	find(endWord, beginWord, wordMap, 1, &res)

	return res
}

func find(target, cur string, wordMap map[string]bool, n int, res *int) {
	if strings.EqualFold(cur, target) {
		if n < *res || *res == 0 {
			*res = n
		}
		return
	}

	for str, bNew := range wordMap {
		if !bNew {
			continue
		}
		if !isOnlyOneCharDiff(str, cur) {
			continue
		}
			wordMap[str] = false
			find(target, str, wordMap, n+1, res)
			wordMap[str] = true
	}
}

func isOnlyOneCharDiff(str1, str2 string) bool {
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


/*
	看过题解，BFS
	反思：
	因为是在刷完N皇后问题之后立刻看的这道题，只是单纯的感觉和N皇后有类似之处，觉得可以用回溯法解答就
	没多想了。
	但是这道题与N皇后有个本质区别在于，N皇后是要输出“所有解”，而此题是要求输出“最小路径解”，因此N皇后问题
	必须遍历所有的节点，用回溯是合理的。
	但对于本题来说，最小路径解，显然用BFS更为合理，这样可以在得出第一个解的时候就直接输出，
	而不用遍历剩余的节点。
	而回溯，其实类似于深度遍历，虽然可以用一些方法记录所在层数，但由于不知道整体的形状，只能全部遍历之后，
	通过比较再得出最优解。
	因此虽然两者的时间复杂度都为O(N*M)，但对于平均情况，BFS比回溯法要节约一半的时间。
*/
func ladderLength2(beginWord string, endWord string, wordList []string) int {
	wordMap := make(map[string]bool, len(wordList))
	for _, v := range wordList {
		wordMap[v] = true
	}
	if !wordMap[endWord] 	{ return 0 }
	res := int(0)
	queue := []string{ beginWord }

	for len(queue) > 0 {
		len := len(queue)
		res++
		for i := 0; i < len; i++ {
			popStr := queue[0]
			queue = queue[1:]
			for str,bNew := range wordMap {
				if !bNew || !isOnlyOneCharDiff(popStr, str) {
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
	优化：
	双向BFS
	即从start，end两点同时向中间进行BFS。

*/

func ladderLengt3(beginWord string, endWord string, wordList []string) int {
	bContain := bool(false)
	for _, str := range wordList {
		if str == endWord {
			bContain = true
			break
		}
	}
	if !bContain { return 0 }

	queue1, queue2 := []string{beginWord}, []string{endWord}
	count1, count2 := int(0), int(0)
	visited1, visited2 := make(map[string]bool), make(map[string]bool)
	visited1[beginWord] = true
	visited2[endWord] = true

	for (len(queue1) != 0) && (len(queue2) != 0) {
		count1++
		l1 := len(queue1)
		for i := 0; i < l1; i++ {
			popStr := queue1[0]
			queue1 = queue1[1:]
			for _, str := range wordList {
				if visited1[str] || !isOnlyOneCharDiff(popStr, str) {
					continue
				}
				if visited2[str] {
					fmt.Println(visited1)
					fmt.Println(visited2)
					return count1 + count2 + 1
				}
				queue1 = append(queue1, str)
				visited1[str] = true
			}
		}

		count2++
		l2 := len(queue2)
		for i := 0; i < l2; i++ {
			popStr := queue2[0]
			queue2 = queue2[1:]
			for _, str := range wordList {
				if visited2[str] || !isOnlyOneCharDiff(popStr, str) {
					continue
				}
				if visited1[str] {
					return count1 + count2 + 1
				}
				queue2 = append(queue2, str)
				visited2[str] = true
			}
		}
	}
	return 0
}
/*
	再优化：每层都从节点少的一方开始进行遍历
*/
func ladderLength(beginWord string, endWord string, wordList []string) int {
	bContain := bool(false)
	for _, str := range wordList {
		if str == endWord {
			bContain = true
			break
		}
	}
	if !bContain { return 0 }

	queue1, queue2 := []string{beginWord}, []string{endWord}
	count1, count2 := int(0), int(0)
	visited1, visited2 := make(map[string]bool), make(map[string]bool)
	visited1[beginWord] = true
	visited2[endWord] = true

	for (len(queue1) != 0) && (len(queue2) != 0) {
		l1 := len(queue1)
		l2 := len(queue2)
		if l1 > l2 {
			queue1, queue2 = queue2, queue1
			l1, l2 = l2, l1
			visited1, visited2 = visited2, visited1
			count1, count2 = count2, count1
		}

		count1++
		for i := 0; i < l1; i++ {
			popStr := queue1[0]
			queue1 = queue1[1:]
			for _, str := range wordList {
				if visited1[str] || !isOnlyOneCharDiff(popStr, str) {
					continue
				}
				if visited2[str] {
					return count1 + count2 + 1
				}
				queue1 = append(queue1, str)
				visited1[str] = true
			}
		}
	}
	return 0
}

func main() {
	start, end := "red", "tax"
	wordList := []string{"ted","tex","red","tax","tad","den","rex","pee"}
	res := ladderLength(start, end, wordList)
	fmt.Println(res)
	return
}




/*
"red"
"tax"
["ted","tex","red","tax","tad","den","rex","pee"]
*/

















