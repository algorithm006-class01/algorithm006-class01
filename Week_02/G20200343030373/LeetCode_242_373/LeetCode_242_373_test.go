//https://leetcode-cn.com/problems/valid-anagram/
package valid_anagram_test

import (
	"github.com/stretchr/testify/assert"
	"reflect"
	"testing"
)

func TestValidAnagram(t *testing.T) {
	t.Log("Valid Anagram - Map")

	s1 := "anagram"
	t1 := "nagaram"
	assert.Equal(t, true, isAnagram(s1, t1))
	assert.Equal(t, true, isAnagramOneMapUnicode(s1, t1))
	assert.Equal(t, true, isAnagramTwoMap(s1, t1))

	s2 := "rat"
	t2 := "car"
	assert.Equal(t, false, isAnagram(s2, t2))
	assert.Equal(t, false, isAnagramOneMapUnicode(s2, t2))
	assert.Equal(t, false, isAnagramTwoMap(s2, t2))
}

func isAnagram(s string, t string) bool {
	return isAnagramOneMapUnicode(s, t)
}

func isAnagramOneMapUnicode(s string, t string) bool {
	//字母异位词的字符数相等，则len取出的字节数也必相等
	//注意：字节数相等，字符数不一定相等
	if len(s) != len(t) {
		return false
	}
	//rune，可兼容string和unicode
	hash := make(map[rune]int, len(s))
	//range string 得到的是rune，也就是int32，如需使用string需类型转换
	//index of string 得到的是byte，不是rune
	for i := 0; i < len(s); i++ {
		hash[rune(s[i])]++
		hash[rune(t[i])]--
	}
	for _, v := range hash {
		if v != 0 {
			return false
		}
	}
	return true
}

func isAnagramTwoMap(s string, t string) bool {
	sMap, tMap := make(map[string]int), make(map[string]int)

	for _, v := range s {
		sMap[string(v)]++
	}

	for _, v := range t {
		tMap[string(v)]++
	}

	return reflect.DeepEqual(sMap, tMap)
}
