package G20200343030501

import (
	"regexp"
	"strings"
)

func reverseWords(s string) string {
	re := regexp.MustCompile("\\s+")
	noSpaceString := strings.TrimSpace(s)
	result := re.Split(noSpaceString, -1)
	var reversed []string
	length := len(result)
	for i := range result {
		n := result[length-1-i]
		reversed = append(reversed, n)
	}
	return strings.Join(reversed, " ")
}
