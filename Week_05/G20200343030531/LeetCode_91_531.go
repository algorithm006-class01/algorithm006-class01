package main

import "fmt"

func main() {
	fmt.Println(numDecodings("1245221"))
}

// 分析，这道题很有意思，看起来很复杂，只要理清边界条件，能取到的数组只有"0"，"1"，"2"
func numDecodings(s string) int {
	if s[0] == '0' {
		return 0
	}

	dp := make([]int, len(s)+1)
	dp[0], dp[1] = 1, 1
	for i := 1; i < len(s); i++ {
		index := i + 1
		if s[i] == '0' {
			if s[i-1] != '1' && s[i-1] != '2' {
				return 0
			} else {
				dp[index] = dp[index-2]
			}
		} else {
			if (s[i-1] == '1') || (s[i-1] == '2' && s[i] <= '6') {
				dp[index] = dp[index-1] + dp[index-2]
			} else {
				dp[index] = dp[index-1]
			}
		}
	}
	return dp[len(s)]
}
