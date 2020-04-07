// https://leetcode-cn.com/problems/decode-ways/
package leetcode

func numDecodings(s string) int {
	n1, n2, res := 1, 1, 1
	data := []byte(s)
	if len(data) == 0 || data[0] == '0' {
		return 0
	}
	for i := 1; i < len(data); i++ {
		if data[i] == '0' {
			if data[i-1] == '1' || data[i-1] == '2' {
				res = n2
			} else {
				return 0
			}

		} else if data[i-1] == '1' {
			res = n1 + n2
		} else if data[i-1] == '2' && data[i] < '7' {
			res = n2 + n1
		} else {
			res = n1
		}
		n2 = n1
		n1 = res
	}
	return res
}
