package main

import "sort"

/*
字母异位词分组

	给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

	示例:

	输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
	输出:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	说明：

	所有输入均为小写字母。
	不考虑答案输出的顺序。
*/
/*
	map[sorted str][old str...]
	这个由于老师课上讲了几句，所以大体思路是有的。
	但是写代码的时候还是苦难重重，估计是因为自己工作中写的代码太简单了。
	导致我并不知道在golang里怎么对字符串本身进行排序，找了半天中终于在国际站中找到了答案。
	由于对这块go语言的不熟悉，导致代码写的很不顺畅，而且go语言在这块是真的麻烦。。。
	写完如下代码，提交完成，击败了59%
	时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的长度。
*/
func groupAnagrams1(strs []string) [][]string {
	if len(strs) == 0 {return nil}
	mapSorted := make(map[string][]string)
	for _, str := range strs {
		b := []byte(str)
		sort.Slice(b, func(i, j int) bool{
			return b[i] < b[j]
		})
		key := string(b)
		mapSorted[key] = append(mapSorted[key], str)
	}
	ret := make([][]string, 0, len(mapSorted))
	for _, strs := range mapSorted {
		ret = append(ret, strs)
	}

	return  ret
}
/*
	因为上面的解法写了两层循环，我在想能不能“顺便”（顺便这个想法是我在第一周自己想出的
	一个规律，也写在了第一周的学习总结中了），即第一个循环就把第二个循环的事情给做了。
	然后想了下，收之前双指针题目的启发，因为第二个指针其实记录的也是一个位置。那么其实我把
	第一个map改下，不放string了，也放一个表示“位置”的元素，然后就可以利用这个位置直接在ret中
	存数据了。
	但是提交后发现性能上并没有改善，还是59%
	比较奇怪的是在看别人的solution的时候，发现一个人用C++写了类似思路的代码，
	但是他却能击败99%的C++解决方案
*/
func groupAnagrams(strs []string) [][]string {
	if len(strs) == 0 {return nil}
	mapIndex := make(map[string]int)
	ret := make([][]string, 0, len(strs))
	index := int(0)
	for _, str := range strs {
		b := []byte(str)
		sort.Slice(b, func(i, j int) bool{
			return b[i] < b[j]
		})
		key := string(b)
		idx, ok := mapIndex[key]
		if !ok {
			mapIndex[key] = index
			ret = append(ret, []string{str})
			index++
		} else {
			ret[idx] = append(ret[idx], str)
		}
	}
	return ret
}

func main() {
	strs := []string{"eat","tea","tan","ate","nat","bat"}
	ret := groupAnagrams(strs)
	print(ret)
	return
}
