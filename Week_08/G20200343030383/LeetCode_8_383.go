// https://leetcode-cn.com/problems/string-to-integer-atoi/

package leetcode

func myAtoi(str string) int {
	data := []byte(str)

	var j int
	for ; j < len(data); j++ {
		if data[j] != ' ' {
			break
		}
	}
	data = data[j:]
	if len(data) == 0 {
		return 0
	}
	var max, sym int64
	if data[0] == '-' {
		sym = -1
		max = int64(math.MinInt32) * -1
		data = data[1:]
	} else {
		sym = 1
		max = int64(math.MaxInt32)
		if data[0] == '+' {
			data = data[1:]
		}
	}
	if len(data) == 0 {
		return 0
	}

	var res int64
	for i, v := range data {
		if v < '0' || v > '9' {
			if i == 0 {
				return 0
			}
			break
		}
		if t := res*10 + int64(v-'0'); t > max {
			res = max
			break
		} else {
			res = t
		}
	}
	return int(res * sym)
}
