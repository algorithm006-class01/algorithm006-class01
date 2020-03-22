package main

import "fmt"

func main() {
	s := "ABCAABBCDEF"
	fmt.Println(leastInterval([]byte(s), len(s)))
}

// 抄的leetcode golang题解，不是很熟练。
func leastInterval(tasks []byte, n int) int {
	s := [26]int{}
	max := 0
	count := 0
	for i := 0; i < len(tasks); i++ {
		s[tasks[i]-'A']++
		if max < s[tasks[i]-'A'] {
			max = s[tasks[i]-'A']
			count = 1
		} else if s[tasks[i]-'A'] == max {
			count++
		}
	}
	if n == 0 || (max-1)*(n+1)+count < len(tasks) {
		return len(tasks)
	}
	return (max-1)*(n+1) + count
}
