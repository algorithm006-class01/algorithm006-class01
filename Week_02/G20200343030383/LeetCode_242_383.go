// https://leetcode-cn.com/problems/valid-anagram/
package leetcode

func isAnagram(s string, t string) bool {
	var note [26]byte
	for _, b := range []byte(s) {
		note[b-'a']++
	}
	for _, b := range []byte(t) {
		note[b-'a']--
	}
	return note == ([26]byte{})
}
