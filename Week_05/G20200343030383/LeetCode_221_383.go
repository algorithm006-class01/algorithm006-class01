// https://leetcode-cn.com/problems/decode-ways/
package leetcode

func maximalSquare(matrix [][]byte) int {
	var s byte = '0'
	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[i][j] == '0' {
				continue
			}
			if l := int(min(matrix[i-1][j], matrix[i][j-1]) - '0'); matrix[i-l][j-l] != '0' {
				matrix[i][j] = byte(l+1) + '0'
			} else {
				matrix[i][j] = byte(l) + '0'
			}
			if matrix[i][j] > s {
				s = matrix[i][j]
			}
		}
	}
	if s == '0' && len(matrix) > 0 && len(matrix[0]) > 0 {
		for _, v := range matrix[0] {
			if v != '0' {
				s = v
				break
			}
		}
	}
	if s == '0' && len(matrix) > 0 && len(matrix[0]) > 0 {
		for i := 0; i < len(matrix); i++ {
			if v := matrix[i][0]; v != '0' {
				s = v
				break
			}
		}
	}
	l := int(s - '0')
	return l * l
}

func min(a, b byte) byte {
	if a < b {
		return a
	}
	return b
}
