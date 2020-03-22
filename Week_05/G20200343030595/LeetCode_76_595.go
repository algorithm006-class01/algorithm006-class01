package main

func minWindow(s string, t string) string {
	hmap := map[byte]int{}
	count := 0
	for _, ch := range []byte(t) {
		if hmap[ch] == 0 {
			count++
		}
		hmap[ch]++
	}
	res := ""
	c := 0
	for i, j := 0, 0; i < len(s); i++ {
		if hmap[s[i]] == 1 {
			c++
		}
		hmap[s[i]]--
		for hmap[s[j]] < 0 {
			hmap[s[j]]++
			j++
			if j > i {
				break
			}
		}
		if c == count {
			if res == "" || len(res) > i-j+1 {
				res = s[j : i+1]
			}
		}
	}
	return res
}