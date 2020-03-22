package main

import "fmt"

func main() {
	fmt.Println(generateParenthesis(4))
}

//
func generateParenthesis(n int) []string {
	ans := make([]string, 0)

	for i := 1; i < n*2; i += 2 {
		buffer := "("
		// 求解子问题
		left := generateParenthesis((i - 1) / 2)
		right := generateParenthesis((2*n - i - 1) / 2)

		// 如果子问题返回的切片是空的，就加一个空字符串方便下面的循环
		if len(left) == 0 {
			left = append(left, "")
		}

		if len(right) == 0 {
			right = append(right, "")
		}
		// 组合两个子问题返回的子字符串
		for _, vl := range left {
			for _, vr := range right {
				temp := buffer + vl + ")" + vr
				ans = append(ans, temp)
			}
		}
	}

	return ans
}
