package main

import (
	"fmt"
	"sort"
)

func main() {
	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	t := groupAnagrams(strs)
	fmt.Println("t == ", t)
}

// 暴力法
/*
	一个个去遍历，去比对
	结果：失败，自己写懵逼了，按照覃超老师说的，不去纠结，看题解，向正确答案靠齐。
*/
/*
func groupAnagrams(strs []string) [][]string {
	// 1.建立临时变量
	temp := make([][]string, len(strs))
	for i := range temp {
		temp[i] = make([]string, 5)
	}
	// 2.循环
	// 2.1 第一层循环，取出比较变量
	for i := 0; i < len(strs); i++ {
		str := strs[i]
		temp[i][0] = str
		//fmt.Println("i = ", i, "str = ", str)
		// 2.2 第二层循环，取出被比较变量
		for j := i+1; j < len(strs)-1;j++  {
			secd := strs[j]
			//fmt.Println("j = ", j, "secd = ", secd)
			// 2.3 第三层循环，一个个字符串比较
			equal := false
			for k := 0; k < len(secd); k++ {
				// 2.4 第四层循环
				for m := 0; m < len(secd); m++ {
					fmt.Println("str[k] = ", str[k], "k = ", k, "secd[m] = ", secd[m], "m = ", m)
					if str[k] == secd[m] {
						fmt.Println("break")
						equal = true
					}
					if m == len(secd) {
						temp[i][len(temp[i])] = secd
					}
				}
				if equal == false {
					break
				}
			}
		}
	}
	return temp
}
*/

// 排序数组分类
/*
	反思：1.字符串排序这一块太繁琐，多了很多步骤，转来转去的
		 2. []byte可以通过string([]byte)强转
		 3. 加入最后的切片中，可以通过map判断然后一步到位，不需要最后另外判断在append
*/
/*
func groupAnagrams(strs []string) [][]string {
	// 1.初始化
	s := make(map[string][]string, len(strs))
	// 2.循环遍历
	for i := 0; i < len(strs); i++ {
		// 2.1字符串排序
		cha := []byte(strs[i])
		len := len(cha)
		temp := make([]string, len)
		for index, value := range cha {
			temp[index] = string(value)
		}
		sort.Strings(temp)
		arrstring := strings.Join(temp, "")
		// 2.2判断字典有没有，有的话加入数组，没有排序后就作为key
		s[arrstring] = append(s[arrstring], strs[i])
	}
	slice := make([][]string, 0)
	for _, value := range s {
		slice = append(slice, value)
	}
	return slice
}
*/

// leetcode 28ms范例
/*
	反思：1、学会使用sort.slice进行排序
		 2、通过map判断有无，存储中间变量map的长度，联系返回值二维数组
		 3、二维数组拼接要注意
*/
func groupAnagrams(strs []string) [][]string {
	// 1.初始化
	res := make([][]string, 0)
	m := make(map[string]int, 0)
	l := len(strs)
	for i := 0; i < l; i++ {
		// 2.排序
		// 2.1字符串转byte
		temp := []byte(strs[i])
		// 2.2排序
		sort.Slice(temp, func(i, j int) bool {
			return temp[i] < temp[j]
		})
		// 2.3判断
		if v, ok := m[string(temp)]; ok == true {
			res[v] = append(res[v], strs[i])
		} else {
			m[string(temp)] = len(m)
			res = append(res, []string{strs[i]})
		}
	}
	return res
}
