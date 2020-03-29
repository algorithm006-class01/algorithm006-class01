package main

func main() {
	isAnagram("abdefea", "efdagag")
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	table := [26]int{}

	for i := 0; i < len(s); i++ {
		table[s[i]-'a'] += 1
		table[t[i]-'a'] -= 1
	}
	for i := 0; i < 26; i++ {
		if table[i] != 0 {
			return false
		}
	}
	return true
}
