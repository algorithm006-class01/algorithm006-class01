package main

func countSubstrings(s string) int {
	n, ans := len(s), 0
	for i:=0; i< 2*n-1; i++ {
		left := i/2
		right := left + i%2
		for left>=0 && right<n && s[left] == s[right] {
			ans += 1
			left--
			right++
		}
	}
	return ans
}
